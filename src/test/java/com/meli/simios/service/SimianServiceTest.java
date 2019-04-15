package com.meli.simios.service;

import com.meli.simios.exception.DnaInvalidException;
import com.meli.simios.exception.InvalidArrayException;
import com.meli.simios.util.FormatUtil;
import com.meli.simios.util.MatrixSequenceUtil;
import com.meli.simios.util.ValidUtil;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class SimianServiceTest {

    @InjectMocks
    private SimianService simianService;

    @Mock
    private ValidUtil validUtil;

    @Mock
    private FormatUtil formatUtil;

    @Mock
    private DnaService dnaService;

    @Mock
    private MatrixSequenceUtil matrixSequenceUtil;

    private final int QT_MAX_SEQUENCE_SIMIAN = 4;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void isSimian_withMatrixWithInvalidData_mustInvokeDnaInvalidException() throws DnaInvalidException, InvalidArrayException {

        try {
            String[] dna = {"DTGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
            when(formatUtil.formatToBidimensionalSimianDna(dna)).thenReturn(this.getMatrixWithInvalidData());
            Boolean simian = simianService.isSimian(dna);
            fail("Test failed");
        } catch (DnaInvalidException e) {
            assertThat(e.getMessage(), is("Dna inválido."));
        }

    }

    @Test
    public void isSimian_withMatrixWithSimianDna_mustReturnTrue() throws DnaInvalidException, InvalidArrayException {

        String[] dna = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        String[][] matrixWithSimianDna = this.getMatrixWithSimianDna();
        when(formatUtil.formatToBidimensionalSimianDna(dna)).thenReturn(matrixWithSimianDna);
        when(matrixSequenceUtil.getAllSequences(matrixWithSimianDna, QT_MAX_SEQUENCE_SIMIAN)).thenReturn(3);
        Boolean isSimian = simianService.isSimian(dna);
        assertTrue(isSimian);

    }

    private String[][] getMatrixWithInvalidData() {

        String[][] matrix = {
                {"D", "T", "G", "C", "G", "A"},
                {"C", "A", "G", "T", "G", "C"},
                {"T", "T", "A", "T", "G", "T"},
                {"A", "G", "A", "A", "G", "G"},
                {"C", "C", "C", "C", "T", "A"},
                {"T", "C", "A", "C", "T", "G"}
        };

        return matrix;

    }

    private String[][] getMatrixWithSimianDna() {

        String[][] matrix = {
                {"A", "T", "G", "C", "G", "A"},
                {"C", "A", "G", "T", "G", "C"},
                {"T", "T", "A", "T", "G", "T"},
                {"A", "G", "A", "A", "G", "G"},
                {"C", "C", "C", "C", "T", "A"},
                {"T", "C", "A", "C", "T", "G"}
        };

        return matrix;

    }
}