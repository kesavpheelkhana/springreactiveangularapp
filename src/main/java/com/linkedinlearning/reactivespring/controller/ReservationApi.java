package com.linkedinlearning.reactivespring.controller;

import com.linkedinlearning.reactivespring.model.Reservation;
import com.linkedinlearning.reactivespring.service.ReservationService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.awt.*;

import static com.linkedinlearning.reactivespring.controller.ReservationApi.ROOM_V1_RESERVATION;

@RestController
@RequestMapping(ROOM_V1_RESERVATION)
@CrossOrigin
public class ReservationApi {

    private final ReservationService reservationService;
    public static final String ROOM_V1_RESERVATION = "/room/v1/reservation/";

    public ReservationApi(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Reservation> getReservationById(@PathVariable String id){
        return  reservationService.getReservation(id);
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Reservation> createReservation(@RequestBody Mono<Reservation> reservation){
        return reservationService.createReservation(reservation);
    }

    @PutMapping(path = "{id}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Reservation> updatePrice(@RequestBody Mono<Reservation> reservation,@PathVariable String id){
        return reservationService.updateReservation(id,reservation);
    }

    @DeleteMapping(path = "{roomId}")
    public Mono<Boolean> deleteReservation(@PathVariable String roomId){
        return reservationService.deleteReservation(roomId);
    }
}
