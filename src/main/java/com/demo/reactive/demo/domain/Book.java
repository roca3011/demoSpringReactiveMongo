package com.demo.reactive.demo.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Book {
    String id;
    String name;
    Integer pages;
    Double price;
    Integer qty;
}
