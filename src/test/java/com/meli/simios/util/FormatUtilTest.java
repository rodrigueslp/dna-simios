package com.meli.simios.util;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FormatUtilTest {

    @InjectMocks
    private FormatUtil formatUtil;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void formatToBidimensionalSimianDna_withArrayUniDimensional_mustReturnArrayBidimensional() {

        String[] arr = {"GTGCGT", "CAGTGC", "TTATAT", "AGAACG", "TCCCTA", "TCACTG"};
        String[][] strings = formatUtil.formatToBidimensionalSimianDna(arr);
        assertThat(strings.length, is(6));

    }
}