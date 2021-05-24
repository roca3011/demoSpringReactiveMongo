package com.demo.reactive.demo.adapter.repository;

import com.demo.reactive.demo.adapter.repository.model.PersonEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepositoryJpa extends ReactiveMongoRepository<PersonEntity,String> {
    //Flux<Product> findByPriceBetween(Range<Double> priceRange);
}
