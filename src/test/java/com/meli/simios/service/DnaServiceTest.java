package com.meli.simios.service;

import com.meli.simios.document.Dna;
import com.meli.simios.enumerator.DnaTypeEnum;
import com.meli.simios.repository.DnaRepository;
import org.bson.types.ObjectId;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

public class DnaServiceTest {

    @InjectMocks
    private DnaService dnaService;

    @Mock
    private DnaRepository dnaRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void saveIfUniqueDna_withExistsDna_mustNeverInvokeSaveMethod() {

        Dna dna = new Dna(new ObjectId(), this.getMatrix(), DnaTypeEnum.HUMAN);
        when(dnaRepository.findByDna(any())).thenReturn(dna);

        dnaService.saveIfUniqueDna(this.getMatrix(), DnaTypeEnum.HUMAN);

        verify(dnaRepository, never()).save(any());

    }

    @Test
    public void saveIfUniqueDna_withoutExistsDna_mustOneTimeInvokeSaveMethod() {

        when(dnaRepository.findByDna(any())).thenReturn(null);

        dnaService.saveIfUniqueDna(this.getMatrix(), DnaTypeEnum.HUMAN);

        verify(dnaRepository, times(1)).save(any());

    }

    @Test
    public void findAllByDnaTypeEnum_withExistsDna_mustReturnList() {

        List<Dna> dnasEsperado = Arrays.asList(new Dna(new ObjectId(), this.getMatrix(), DnaTypeEnum.MUTANT));
        when(dnaRepository.findAllByDnaTypeEnum(DnaTypeEnum.MUTANT)).thenReturn(dnasEsperado);

        List<Dna> dnasAtual = dnaService.findAllByDnaTypeEnum(DnaTypeEnum.MUTANT);

        Assert.assertThat(dnasAtual, is(dnasEsperado));

    }

    private String[][] getMatrix() {

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