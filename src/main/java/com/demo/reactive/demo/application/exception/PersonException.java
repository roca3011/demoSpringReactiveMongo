package com.demo.reactive.demo.application.exception;

import com.demo.reactive.demo.config.exception.ErrorCode;

public final class PersonException extends GenericException{
    public PersonException(ErrorCode errorCode) {
        super(errorCode);
    }
}
