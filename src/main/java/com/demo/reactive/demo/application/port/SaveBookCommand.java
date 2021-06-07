package com.demo.reactive.demo.application.port;

import com.demo.reactive.demo.domain.Book;
import com.demo.reactive.demo.domain.Person;

public interface SaveBookCommand {

    Person execute(String clientId, Book book);
}
