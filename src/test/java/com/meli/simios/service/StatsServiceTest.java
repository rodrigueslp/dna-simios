package com.meli.simios.service;

import com.meli.simios.document.Dna;
import com.meli.simios.dto.StatsDto;
import com.meli.simios.enumerator.DnaTypeEnum;
import org.bson.types.ObjectId;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class StatsServiceTest {

    @InjectMocks
    private StatsService statsService;

    @Mock
    private DnaService dnaService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getStatsMutantAndHuman_withMutantsAndHumans_mustCreateStats() {

        List<Dna> dnasHumans = Arrays.asList(new Dna(new ObjectId(), this.getMatrix(), DnaTypeEnum.HUMAN));
        Mockito.when(dnaService.findAllByDnaTypeEnum(DnaTypeEnum.HUMAN)).thenReturn(dnasHumans);

        List<Dna> dnaMutants = Arrays.asList(new Dna(new ObjectId(), this.getMatrix(), DnaTypeEnum.MUTANT));
        Mockito.when(dnaService.findAllByDnaTypeEnum(DnaTypeEnum.MUTANT)).thenReturn(dnaMutants);

        StatsDto statsMutantAndHuman = statsService.getStatsMutantAndHuman();

        assertThat(statsMutantAndHuman.getCount_human_dna(), is(1));
        assertThat(statsMutantAndHuman.getCount_mutant_dna(), is(1));
        assertThat(statsMutantAndHuman.getRatio(), is((float)1.0));

    }

    @Test
    public void getStatsMutantAndHuman_withoutMutantsAndHumans_mustCreateStats() {

        Mockito.when(dnaService.findAllByDnaTypeEnum(DnaTypeEnum.HUMAN)).thenReturn(null);
        Mockito.when(dnaService.findAllByDnaTypeEnum(DnaTypeEnum.MUTANT)).thenReturn(null);

        StatsDto statsMutantAndHuman = statsService.getStatsMutantAndHuman();

        assertThat(statsMutantAndHuman.getCount_human_dna(), is(0));
        assertThat(statsMutantAndHuman.getCount_mutant_dna(), is(0));
        assertThat(statsMutantAndHuman.getRatio(), is((float)0.0));

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
