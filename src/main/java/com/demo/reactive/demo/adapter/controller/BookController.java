package com.demo.reactive.demo.adapter.controller;

import com.demo.reactive.demo.adapter.controller.model.SaveBookRequest;
import com.demo.reactive.demo.application.port.SaveBookCommand;
import com.demo.reactive.demo.domain.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/books")
public class BookController {

    private final  SaveBookCommand saveBookCommand;

    public BookController(SaveBookCommand saveBookCommand) {
        this.saveBookCommand = saveBookCommand;
    }

    @PostMapping
    public ResponseEntity<Mono<Person>> saveProduct(@Valid @RequestBody SaveBookRequest saveBookRequest){
        Mono<Person> personMono = saveBookCommand.execute(saveBookRequest.getId(), saveBookRequest.getBook().toDomain());
        return new ResponseEntity<>(personMono, HttpStatus.CREATED);
    }
}
