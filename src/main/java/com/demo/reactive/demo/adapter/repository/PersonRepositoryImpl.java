package com.demo.reactive.demo.adapter.repository;

import com.demo.reactive.demo.adapter.repository.model.PersonEntity;
import com.demo.reactive.demo.application.port.PersonRepository;
import com.demo.reactive.demo.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    @Autowired
    private PersonRepositoryJpa personRepositoryJpa;

    @Override
    public Mono<Person> save(Mono<Person> personMono){
        return personMono.map(PersonEntity::dtoToEntity)
                .flatMap(personRepositoryJpa::insert)
                .map(PersonEntity::entityToDto);
    }

    @Override
    public Mono<Person> findById(String clientId) {
        return personRepositoryJpa.findById(clientId)
                .map(PersonEntity::entityToDto);
    }
}
