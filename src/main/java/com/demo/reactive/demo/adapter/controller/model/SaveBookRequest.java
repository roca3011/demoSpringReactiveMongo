package com.demo.reactive.demo.adapter.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveBookRequest {

    @NotNull private String clientId;
    @NotNull private BookDto book;
}
