package com.meli.simios.controller;

import com.meli.simios.dto.DnaDto;
import com.meli.simios.exception.DnaInvalidException;
import com.meli.simios.exception.InvalidArrayException;
import com.meli.simios.exception.MatrixNotSquareException;
import com.meli.simios.exception.SimiosCommonException;
import com.meli.simios.service.SimianService;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.concurrent.ExecutionException;

import static org.mockito.Mockito.when;

public class SimianControllerTest {

    @InjectMocks
    private SimianController simianController;

    @Mock
    private SimianService simianService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void isSimian_withSimianDna_mustReturnHttp200Ok() throws InterruptedException, ExecutionException, SimiosCommonException {

        String[] dna = {"GTGCGT", "CAGTGC", "TTATAT", "AGAACG", "CCCCTA", "TCACTG"};

        when(simianService.isSimian(dna)).thenReturn(Boolean.TRUE);

        DnaDto dnaDto = new DnaDto(dna);

        ResponseEntity responseEntity = simianController.isSimian(dnaDto);

        Assert.assertThat(responseEntity.getStatusCode(), CoreMatchers.is(HttpStatus.OK));

    }

    @Test
    public void isSimian_withSimianDna_mustReturnHttp403Forbbiden() throws InterruptedException, ExecutionException, SimiosCommonException {

        String[] dna = {"GTGCGT", "CAGTGC", "TTATAT", "AGAACG", "TCCCTA", "TCACTG"};

        when(simianService.isSimian(dna)).thenReturn(Boolean.FALSE);

        DnaDto dnaDto = new DnaDto(dna);

        ResponseEntity responseEntity = simianController.isSimian(dnaDto);

        Assert.assertThat(responseEntity.getStatusCode(), CoreMatchers.is(HttpStatus.FORBIDDEN));

    }



}