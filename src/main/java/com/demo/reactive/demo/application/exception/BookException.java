package com.demo.reactive.demo.application.exception;

import com.demo.reactive.demo.config.exception.ErrorCode;

public final class BookException extends GenericException{
    public BookException(ErrorCode errorCode) {
        super(errorCode);
    }
}
