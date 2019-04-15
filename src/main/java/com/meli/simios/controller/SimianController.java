package com.meli.simios.controller;

import com.meli.simios.dto.DnaDto;
import com.meli.simios.exception.DnaInvalidException;
import com.meli.simios.exception.InvalidArrayException;
import com.meli.simios.service.SimianService;
import com.meli.simios.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class SimianController {

    @Autowired
    private SimianService simianService;

    private StatsService statsService;

    @PostMapping
    @RequestMapping("/simian")
    public ResponseEntity isSimian(@RequestBody DnaDto dnaDto) throws DnaInvalidException, InvalidArrayException, ExecutionException, InterruptedException {

        return simianService.isSimian(dnaDto.getDna())
                ? ResponseEntity.status(HttpStatus.OK).build()
                : ResponseEntity.status(HttpStatus.FORBIDDEN).build();

    }

}
