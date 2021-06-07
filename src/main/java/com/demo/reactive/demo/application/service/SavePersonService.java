package com.demo.reactive.demo.application.service;

import com.demo.reactive.demo.application.exception.PersonException;
import com.demo.reactive.demo.application.port.PersonRepository;
import com.demo.reactive.demo.application.port.SavePersonCommand;
import com.demo.reactive.demo.config.exception.ErrorCode;
import com.demo.reactive.demo.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SavePersonService implements SavePersonCommand {

    private final PersonRepository personRepository;

    public SavePersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @Override
    public Person execute(Person person) {

        personRepository.findByCardNumber(person.getCardNumber()).ifPresent(this::validateExistence);
        return personRepository.save(person);
    }

    private void validateExistence(Person value) {
        throw new PersonException(ErrorCode.ERROR_SAVED_PERSON);
    }
}
