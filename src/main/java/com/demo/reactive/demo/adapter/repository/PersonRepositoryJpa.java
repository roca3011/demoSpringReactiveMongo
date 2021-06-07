package com.demo.reactive.demo.adapter.repository;

import com.demo.reactive.demo.adapter.repository.model.PersonEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepositoryJpa extends MongoRepository<PersonEntity,String> {
    Optional<PersonEntity> findByCardNumber(String cardNumber);

}
