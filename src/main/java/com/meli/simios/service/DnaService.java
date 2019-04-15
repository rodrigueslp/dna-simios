package com.meli.simios.service;

import com.meli.simios.DnaRepository;
import com.meli.simios.document.Dna;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DnaService {

    @Autowired
    private DnaRepository dnaRepository;

    public void saveIfUniqueDna(String[][] dna) {
        Dna dnaSaved = dnaRepository.findByDna(dna);
        if (dnaSaved == null) {
            Dna dnaDocument = new Dna();
            dnaDocument.setDna(dna);
            dnaRepository.save(dnaDocument);
        }
    }

    public List<Dna> findAll() {
        return dnaRepository.findAll();
    }

}
