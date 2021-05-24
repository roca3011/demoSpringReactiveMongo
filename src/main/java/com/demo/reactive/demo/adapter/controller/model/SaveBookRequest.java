package com.demo.reactive.demo.adapter.controller.model;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveBookRequest {

    @NotNull private String id;
    @NotNull private BookDto book;
}
