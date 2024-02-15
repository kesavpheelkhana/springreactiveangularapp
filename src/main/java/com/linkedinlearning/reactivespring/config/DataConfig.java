package com.linkedinlearning.reactivespring.config;

import com.mongodb.reactivestreams.client.MongoClient;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.SimpleReactiveMongoDatabaseFactory;

@Configuration
@Profile(value = "local")
@Import({MongoAutoConfiguration.class})
public class DataConfig {
    public static final String DATABASE_NAME = "reservations";


    @Bean
    public ReactiveMongoDatabaseFactory reactiveMongoDatabaseFactory(MongoClient mongoClient){
        return new SimpleReactiveMongoDatabaseFactory(mongoClient,DATABASE_NAME);
    }

    public ReactiveMongoOperations reactiveMongoTemplate(ReactiveMongoDatabaseFactory  mongoDatabaseFactory){
        return new ReactiveMongoTemplate(mongoDatabaseFactory);
    }
}
