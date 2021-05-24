package com.demo.reactive.demo.application.service;

import com.demo.reactive.demo.application.exception.BookException;
import com.demo.reactive.demo.application.port.PersonRepository;
import com.demo.reactive.demo.application.port.SaveBookCommand;
import com.demo.reactive.demo.config.exception.ErrorCode;
import com.demo.reactive.demo.domain.Book;
import com.demo.reactive.demo.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class SaveBookService implements SaveBookCommand {

    private final PersonRepository personRepository;

    public SaveBookService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @Override
    public Mono<Person> execute(String idClient, Book book){
        Mono<Person> person = personRepository.findById(idClient);
        Person getPerson = Objects.nonNull(person)?person.block():null;
        if (Objects.nonNull(getPerson)){
            List<Book> newBooks = new ArrayList<>(getPerson.getBooks());
            newBooks.add(book);
            getPerson.withBooks(newBooks);
            log.info("libro(s) agregados correctamente{}",getPerson);
            return personRepository.save(Mono.just(getPerson));
        } else log.info("libro(s) no agregados {}",person);
        throw new BookException(ErrorCode.ERROR_SAVED_BOOK);
    }
}
