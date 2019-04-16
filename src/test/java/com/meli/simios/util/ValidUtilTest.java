package com.meli.simios.util;

import com.meli.simios.exception.InvalidArrayException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ValidUtilTest {

    @InjectMocks
    private ValidUtil validUtil;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validArray_withEmptyArray_mustInvokeArrayInvalidException()  {

        try {
            String[] arr = new String[0];
            validUtil.validArray(arr);
        } catch (InvalidArrayException e) {
            assertThat(e.getMessage(), is("Array nulo ou vazio."));
        }

    }

    @Test
    public void validArray_withNullArray_mustInvokeArrayInvalidException()  {

        try {
            validUtil.validArray(null);
        } catch (InvalidArrayException e) {
            assertThat(e.getMessage(), is("Array nulo ou vazio."));
        }

    }
}