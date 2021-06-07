package com.demo.reactive.demo.domain;

import lombok.Builder;
import lombok.Value;
import lombok.With;

@Value
@Builder
@With
public class Book {
    String name;
    Integer pages;
    Double price;
    Integer qty;
}
