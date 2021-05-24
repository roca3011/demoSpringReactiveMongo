package com.demo.reactive.demo.domain;

import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.util.List;

@Value
@Builder
public class Person {
    String id;
    String firstName;
    String lastName;
    String address;
    String celPhone;
    @With
    List<Book> books;
}
