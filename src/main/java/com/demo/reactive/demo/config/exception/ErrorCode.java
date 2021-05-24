package com.demo.reactive.demo.config.exception;

public enum ErrorCode {

    ERROR_SAVED_BOOK( "Error saved book(s)");

    private final String reasonPhrase;

    ErrorCode(String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
    }

    public String getReasonPhrase() {
        return this.reasonPhrase;
    }
}
