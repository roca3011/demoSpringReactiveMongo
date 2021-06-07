package com.demo.reactive.demo.adapter.controller.model;

import com.demo.reactive.demo.domain.Book;
import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
@Builder
public class BookDto {
    @NotNull String name;
    Integer pages;
    Double price;
    Integer qty;

    public Book toDomain(){
        return Book.builder()
                .name(name)
                .qty(qty)
                .price(price)
                .pages(pages)
                .build();
    }
}
