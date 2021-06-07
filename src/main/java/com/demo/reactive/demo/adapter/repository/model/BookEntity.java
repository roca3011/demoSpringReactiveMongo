package com.demo.reactive.demo.adapter.repository.model;

import com.demo.reactive.demo.domain.Book;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class BookEntity {
    String name;
    Integer pages;
    Double price;
    Integer qty;

    public static Book toDto(BookEntity bookEntity){
        return Book.builder()
                .name(bookEntity.getName())
                .pages(bookEntity.getPages())
                .price(bookEntity.getPrice())
                .qty(bookEntity.getQty())
                .build();
    }

    public static BookEntity toEntity(Book book){
        return BookEntity.builder()
                .name(book.getName())
                .pages(book.getPages())
                .price(book.getPrice())
                .qty(book.getQty())
                .build();
    }
}
