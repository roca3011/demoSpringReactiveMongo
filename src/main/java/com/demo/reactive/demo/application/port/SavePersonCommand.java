package com.demo.reactive.demo.application.port;

import com.demo.reactive.demo.domain.Person;

public interface SavePersonCommand {
    Person execute(Person toDto);
}
