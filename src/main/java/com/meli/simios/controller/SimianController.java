package com.meli.simios.controller;

import com.meli.simios.business.SimianBusiness;
import com.meli.simios.dto.DnaDto;
import com.meli.simios.exception.DnaInvalidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimianController {

    @Autowired
    private SimianBusiness simianBusiness;

    @PostMapping
    @RequestMapping("/simian")
    public ResponseEntity isSimian(@RequestBody DnaDto dnaDto) throws DnaInvalidException {

        /*String[][] dna = {
                {"C", "C", "A", "A", "A", "A"},
                {"C", "C", "A", "C", "G", "C"},
                {"A", "A", "G", "G", "T", "T"},
                {"A", "A", "G", "C", "C", "T"},
                {"C", "G", "A", "A", "G", "T"},
                {"C", "C", "A", "A", "T", "T"}
        };*/


        return simianBusiness.isSimian(dnaDto.getDna())
                ? ResponseEntity.status(HttpStatus.OK).build()
                : ResponseEntity.status(HttpStatus.FORBIDDEN).build();

    }

}
