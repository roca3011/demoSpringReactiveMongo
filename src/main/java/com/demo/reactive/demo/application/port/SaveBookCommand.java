package com.demo.reactive.demo.application.port;

import com.demo.reactive.demo.domain.Book;
import com.demo.reactive.demo.domain.Person;
import reactor.core.publisher.Mono;

public interface SaveBookCommand {

    Mono<Person> execute(String idClient, Book book);
}
