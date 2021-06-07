package com.demo.reactive.demo.adapter.repository.model;

import com.demo.reactive.demo.domain.Book;
import com.demo.reactive.demo.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "persons")
public class PersonEntity {
    @Id
    String id;
    String cardNumber;
    String firstName;
    String lastName;
    String address;
    String celPhone;
    Map<String, BookEntity> bookEntities;

    public static Person entityToDto(PersonEntity personEntity){
        return Person.builder()
                .id(personEntity.getId())
                .cardNumber(personEntity.cardNumber)
                .address(personEntity.address)
                .celPhone(personEntity.celPhone)
                .firstName(personEntity.firstName)
                .lastName(personEntity.lastName)
                .books(Objects.nonNull(personEntity.getBookEntities()) ? getCollect(personEntity) : null)
                .build();
    }

    public static PersonEntity dtoToEntity(Person person){
        return PersonEntity.builder()
                .id(person.getId())
                .cardNumber(person.getCardNumber())
                .address(person.getAddress())
                .celPhone(person.getCelPhone())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .bookEntities(Objects.nonNull(person.getBooks()) ? getCollect(person) : null)
                .build();
    }

    private static Map<String, BookEntity> getCollect(Person person) {
        return person.getBooks().entrySet()
                .stream()
                .collect(Collectors.toMap(k -> String.valueOf(k.getKey()), v -> BookEntity.toEntity( v.getValue())));
    }

    private static Map<String, Book> getCollect(PersonEntity personEntity) {
        return personEntity.getBookEntities()
                .entrySet()
                .stream()
                .collect(Collectors.toMap(k -> String.valueOf(k.getKey()), v -> BookEntity.toDto(v.getValue())));
    }
}
