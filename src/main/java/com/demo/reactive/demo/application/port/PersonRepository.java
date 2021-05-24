package com.demo.reactive.demo.application.port;

import com.demo.reactive.demo.domain.Person;
import reactor.core.publisher.Mono;

public interface PersonRepository {
    Mono<Person> save(Mono<Person> personMono);

    Mono<Person> findById(String clientId);
}
