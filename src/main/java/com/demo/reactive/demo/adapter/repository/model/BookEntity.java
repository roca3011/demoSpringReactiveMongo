package com.demo.reactive.demo.adapter.repository.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class BookEntity {
    String id;
    String name;
    Integer pages;
    Double price;
    Integer qty;
}
