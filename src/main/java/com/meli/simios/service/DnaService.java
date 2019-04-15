package com.meli.simios.service;

import com.meli.simios.repository.DnaRepository;
import com.meli.simios.document.Dna;
import com.meli.simios.enumerator.DnaTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DnaService {

    @Autowired
    private DnaRepository dnaRepository;

    public void saveIfUniqueDna(String[][] dna, DnaTypeEnum dnaTypeEnum) {
        Dna dnaSaved = dnaRepository.findByDna(dna);
        if (dnaSaved == null) {
            Dna dnaDocument = new Dna();
            dnaDocument.setDna(dna);
            dnaDocument.setDnaTypeEnum(dnaTypeEnum);
            dnaRepository.save(dnaDocument);
        }
    }

    public List<Dna> findAllByDnaTypeEnum(DnaTypeEnum dnaTypeEnum) {
        return dnaRepository.findAllByDnaTypeEnum(dnaTypeEnum);
    }

}
