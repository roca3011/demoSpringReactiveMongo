package com.demo.reactive.demo.adapter.repository;

import com.demo.reactive.demo.adapter.repository.model.PersonEntity;
import com.demo.reactive.demo.application.port.PersonRepository;
import com.demo.reactive.demo.domain.Person;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    @Autowired
    private PersonRepositoryJpa personRepositoryJpa;

    @Override
    public Person save(Person person){
        var personEntity = personRepositoryJpa.save(PersonEntity.dtoToEntity(person));
        return PersonEntity.entityToDto(personEntity);
    }

    @Override
    public Optional<Person> findById(String clientId) {
        return personRepositoryJpa.findById(clientId)
                .map(PersonEntity::entityToDto);
    }

    @Override
    public Optional<Person> findByCardNumber(String cardNumber) {
        return personRepositoryJpa.findByCardNumber(cardNumber)
                .map(PersonEntity::entityToDto);
    }

    @Override
    public List<Person> findByAll() {
        var personEntities = personRepositoryJpa.findAll();
        return personEntities.stream().map(PersonEntity::entityToDto).collect(Collectors.toList());
    }
}
