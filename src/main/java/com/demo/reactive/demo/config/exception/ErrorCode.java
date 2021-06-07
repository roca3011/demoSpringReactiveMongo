package com.demo.reactive.demo.config.exception;

public enum ErrorCode {

    ERROR_SAVED_BOOK( "Error saved book(s)"),
    INTERNAL_ERROR("Internal error"),
    BAD_REQUEST("Bad request"),
    ERROR_SAVED_PERSON( "Error saved person");

    private final String reasonPhrase;

    ErrorCode(String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
    }

    public String getReasonPhrase() {
        return this.reasonPhrase;
    }
}
