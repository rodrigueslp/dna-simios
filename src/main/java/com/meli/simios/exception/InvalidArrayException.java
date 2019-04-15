package com.meli.simios.exception;

import org.springframework.http.HttpStatus;

public class InvalidArrayException extends SimiosCommonException {

    public InvalidArrayException() {
        super("Array nulo ou vazio.", HttpStatus.BAD_REQUEST);
    }

}
