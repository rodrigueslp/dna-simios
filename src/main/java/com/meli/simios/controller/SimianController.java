package com.meli.simios.controller;

import com.meli.simios.dto.StatsDto;
import com.meli.simios.service.SimianService;
import com.meli.simios.dto.DnaDto;
import com.meli.simios.exception.DnaInvalidException;
import com.meli.simios.exception.InvalidArrayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SimianController {

    @Autowired
    private SimianService simianService;

    @PostMapping
    @RequestMapping("/simian")
    public ResponseEntity isSimian(@RequestBody DnaDto dnaDto) throws DnaInvalidException, InvalidArrayException {

        return simianService.isSimian(dnaDto.getDna())
                ? ResponseEntity.status(HttpStatus.OK).build()
                : ResponseEntity.status(HttpStatus.FORBIDDEN).build();

    }

    @GetMapping
    @RequestMapping("/stats")
    public ResponseEntity<Object> stats() {
        StatsDto stats = simianService.getStats();
        return ResponseEntity.status(HttpStatus.OK).body(stats);
    }

}
