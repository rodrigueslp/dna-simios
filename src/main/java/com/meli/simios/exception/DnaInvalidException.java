package com.meli.simios.exception;

import org.springframework.http.HttpStatus;

public class DnaInvalidException extends SimiosCommonException {

    public DnaInvalidException() {
        super("Dna inválido.", HttpStatus.BAD_REQUEST);
    }

}
