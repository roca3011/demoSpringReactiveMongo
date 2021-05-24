package com.demo.reactive.demo.adapter.controller.model;

import com.demo.reactive.demo.domain.Book;
import com.sun.istack.internal.NotNull;
import lombok.Builder;
import lombok.Value;

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
