package com.meli.simios.controller;

import com.meli.simios.dto.StatsDto;
import com.meli.simios.service.StatsService;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class StatsControllerTest {

    @InjectMocks
    private StatsController statsController;

    @Mock
    private StatsService statsService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void stats_mustReturnStatsDto_withHttp200Ok() throws ExecutionException, InterruptedException {

        StatsDto statsDto = new StatsDto(10, 5, (float) 0.5);
        when(statsService.getStatsMutantAndHuman()).thenReturn(statsDto);

        ResponseEntity<Object> stats = statsController.stats();

        assertThat(stats.getBody(), CoreMatchers.is(statsDto));
        assertThat(stats.getStatusCode(), CoreMatchers.is(HttpStatus.OK));

    }
}