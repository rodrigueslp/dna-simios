package com.meli.simios.util;

import com.meli.simios.exception.MatrixNotSquareException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class FormatUtilTest {

    @InjectMocks
    private FormatUtil formatUtil;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void formatToBidimensionalSimian_withArrayUniDimensional_mustReturnArrayBidimensional() throws MatrixNotSquareException {

        String[] arr = {"GTGCGT", "CAGTGC", "TTATAT", "AGAACG", "TCCCTA", "TCACTG"};
        String[][] strings = formatUtil.formatToSquareBidimensional(arr);
        assertThat(strings.length, is(6));

    }

    @Test
    public void formatToBidimensionalSimian_withNotSquareMatrix_mustInvokeMatrixNotSquareException() {

        try {

            String[] arr1 = {"GTGCGT", "CAGTGC", "TTATAT", "AGAACG", "TCCCTA", "TCACTG", "TCACTG"};
            formatUtil.formatToSquareBidimensional(arr1);

            fail("Failed test");

        } catch (MatrixNotSquareException e) {
            assertThat(e.getMessage(), is("Matriz não é quadrada."));
        }

    }

    @Test
    public void formatToBidimensionalSimian_withNotSquareMatrix2_mustInvokeMatrixNotSquareException() {

        try {

            String[] arr1 = {"GTGCGTT", "CAGTGC", "TTATATTTTT", "AGAACG", "TCCCTAAG", "TC"};
            formatUtil.formatToSquareBidimensional(arr1);

            fail("Failed test");

        } catch (MatrixNotSquareException e) {
            assertThat(e.getMessage(), is("Matriz não é quadrada."));
        }

    }

    @Test
    public void formatToBidimensionalSimian_withNotSquareMatrix3_mustInvokeMatrixNotSquareException() {

        try {

            String[] arr1 = {"GTGCGTT", "GTGC", "TTATAT", "AGAACG", "TCCCTAAG", "TC"};
            formatUtil.formatToSquareBidimensional(arr1);

            fail("Failed test");

        } catch (MatrixNotSquareException e) {
            assertThat(e.getMessage(), is("Matriz não é quadrada."));
        }

    }
}