package com.meli.simios.util;

import com.meli.simios.exception.InvalidArrayException;
import org.springframework.stereotype.Component;

@Component
public class ValidUtil {

    public void validArray(String[] array) throws InvalidArrayException {
        if (array == null || array.length < 1) {
            throw new InvalidArrayException();
        }
    }

}
