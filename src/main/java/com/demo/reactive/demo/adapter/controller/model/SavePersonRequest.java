package com.demo.reactive.demo.adapter.controller.model;

import com.demo.reactive.demo.domain.Person;
import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
@Builder
public class SavePersonRequest {

    String firstName;
    String lastName;
    String address;
    String celPhone;
    @NotNull
    String cardNumber;

    public Person toDto(){
        return Person.builder()
                .cardNumber(cardNumber)
                .firstName(firstName)
                .lastName(lastName)
                .celPhone(celPhone)
                .address(address)
                .build();
    }
}
