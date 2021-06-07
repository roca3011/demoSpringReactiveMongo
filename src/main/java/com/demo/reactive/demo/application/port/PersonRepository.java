package com.demo.reactive.demo.application.port;

import com.demo.reactive.demo.domain.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {
    Person save(Person person);

    Optional<Person> findById(String clientId);

    Optional<Person> findByCardNumber(String cardNumber);

    List<Person> findByAll();
}
