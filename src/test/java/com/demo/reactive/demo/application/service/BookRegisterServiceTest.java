package com.demo.reactive.demo.application.service;

import com.demo.reactive.demo.adapter.repository.PersonRepositoryImpl;
import com.demo.reactive.demo.config.exception.ErrorCode;
import com.demo.reactive.demo.domain.Book;
import com.demo.reactive.demo.domain.Person;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
public class BookRegisterServiceTest {

    @Mock
    private PersonRepositoryImpl personRepository;

    @InjectMocks
    private SaveBookService saveBookService;

    @Test
    public void addBookToPersonReturnOK(){
        String clientId = "1";
        Book newBook = fakeBook("Book3");

        Map<String, Book> books = new HashMap<>();
        books.put("OneBook",fakeBook("OneBook"));
        books.put("TwoBook",fakeBook("TwoBook"));

        Optional<Person> getPersonMono = Optional.of(fakePerson(books));

        Map<String, Book> newBooks = new HashMap<>(books);
        newBooks.put("Book3",newBook);
        Person newPersonMono = fakePerson(newBooks);

        when(personRepository.findById(clientId)).thenReturn(getPersonMono);
        when(personRepository.save(any())).thenReturn(newPersonMono);
        Person result = saveBookService.execute(clientId, newBook);

        Assert.assertEquals(newPersonMono, result);
    }

    @Test
    public void addBookToPersonReturnBookException(){
        String clientId = "1";
        Book newBook = fakeBook("3");

        when(personRepository.findById(clientId)).thenReturn(null);

        try {
            saveBookService.execute(clientId, newBook);
            fail();
        }catch(Exception e){
            Assert.assertEquals(ErrorCode.ERROR_SAVED_BOOK.getReasonPhrase(), e.getMessage());
        }
    }

    private Person fakePerson(Map<String, Book> books) {
        return Person.builder()
                .id("1")
                .firstName("firstNameTest")
                .lastName("lastNameTest")
                .address("cra 123")
                .celPhone("1233")
                .books(books)
                .build();
    }

    private Book fakeBook(String name) {
        return  Book.builder()
                .name(name)
                .pages(100)
                .price(10000.0)
                .qty(1)
                .build();
    }
}
