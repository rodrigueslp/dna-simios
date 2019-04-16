package com.meli.simios.exception;

import org.springframework.http.HttpStatus;

public class MatrixNotSquareException extends SimiosCommonException {

    public MatrixNotSquareException() {
        super("Matriz não é quadrada.", HttpStatus.BAD_REQUEST);
    }
}
