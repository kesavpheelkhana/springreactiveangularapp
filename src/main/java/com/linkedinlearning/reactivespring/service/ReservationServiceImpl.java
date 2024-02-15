package com.linkedinlearning.reactivespring.service;

import com.linkedinlearning.reactivespring.model.Reservation;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import static java.lang.Thread.sleep;

@Service
public class ReservationServiceImpl implements ReservationService{

    private final ReactiveMongoOperations reactiveMongoOperations;

    public ReservationServiceImpl(ReactiveMongoOperations reactiveMongoOperations) {
        this.reactiveMongoOperations = reactiveMongoOperations;
    }

    @Override
    public Mono<Reservation> getReservation(String id) {
        return reactiveMongoOperations.findById(id,Reservation.class);
    }

    @Override
    public Mono<Reservation> createReservation(Mono<Reservation> reservation) {

        //upsert functionality
        return reactiveMongoOperations.save(reservation);
    }

    @Override
    public Mono<Reservation> updateReservation(String id, Mono<Reservation> reservation) {
        System.out.println("reservation id "+id);
//        System.out.println("reservation amount to update "+reservation.block().getPrice());
        return reservation.flatMap(this::applys);
    }

    @Override
    public Mono<Boolean> deleteReservation(String id) {
        return reactiveMongoOperations.remove(
                Query.query(Criteria.where("id").is(id)),Reservation.class)
                .flatMap(deleteResult -> Mono.just(deleteResult.wasAcknowledged()));
    }

    private Mono<? extends Reservation> applys(Reservation reservation) {
        System.out.println("applying resevavtion "+reservation.getId());
        try {
             sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return reactiveMongoOperations.findAndModify(
                Query.query(Criteria.where("id").is("65ce12151214563061d16935")),
                Update.update("price", reservation.getPrice()), Reservation.class
                ).flatMap(result -> {
                    result.setPrice(reservation.getPrice());
                    return Mono.just(result);
    });
    }
}
