package com.demo.reactive.demo.domain;

import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Value
@Builder
public class Person implements Cloneable{
    String id;
    String cardNumber;
    String firstName;
    String lastName;
    String address;
    String celPhone;
    @With
    Map<String, Book> books;

    @Override
    public Object clone() {
        return Person.builder()
                .id(id)
                .cardNumber(cardNumber)
                .firstName(firstName)
                .lastName(lastName)
                .address(address)
                .celPhone(celPhone)
                .books(Objects.nonNull(books)?books:new HashMap<>())
                .build();
    }
}
