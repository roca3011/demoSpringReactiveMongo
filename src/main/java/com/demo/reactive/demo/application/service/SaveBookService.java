package com.demo.reactive.demo.application.service;

import com.demo.reactive.demo.application.exception.BookException;
import com.demo.reactive.demo.application.port.PersonRepository;
import com.demo.reactive.demo.application.port.SaveBookCommand;
import com.demo.reactive.demo.config.exception.ErrorCode;
import com.demo.reactive.demo.domain.Book;
import com.demo.reactive.demo.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class SaveBookService implements SaveBookCommand {

    private final PersonRepository personRepository;

    public SaveBookService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @Override
    public Person execute(String clientId, Book book){
        Optional<Person> personOp = personRepository.findById(clientId);
        Person person = personOp.orElseThrow(() -> {
            log.info("libro(s) no agregados {}",personOp);
            return new BookException(ErrorCode.ERROR_SAVED_BOOK);
        });

        Person updated = addNewBook(book, person);
        return personRepository.save(updated);
    }

    private Person addNewBook(Book book, Person person) {
        Person updatePerson = (Person) person.clone();
        updatePerson.getBooks().put(book.getName(),book);
        log.info("libro(s) agregados{}", updatePerson);
        return updatePerson;
    }
}
