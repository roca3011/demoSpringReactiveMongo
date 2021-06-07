package com.demo.reactive.demo.adapter.controller;

import com.demo.reactive.demo.adapter.controller.model.SavePersonRequest;
import com.demo.reactive.demo.application.port.SavePersonCommand;
import com.demo.reactive.demo.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
@RequestMapping("/persons")
public class PersonController {

    private final SavePersonCommand savePersonCommand;

    public PersonController( SavePersonCommand savePersonCommand) {
        this.savePersonCommand = savePersonCommand;
    }

    @PostMapping
    public ResponseEntity<Person> savePerson(@Valid @RequestBody SavePersonRequest saveBookRequest){
        Person person = savePersonCommand.execute(saveBookRequest.toDto());
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }
}
