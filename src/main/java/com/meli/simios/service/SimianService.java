package com.meli.simios.service;

import com.meli.simios.document.Dna;
import com.meli.simios.dto.StatsDto;
import com.meli.simios.exception.DnaInvalidException;
import com.meli.simios.exception.InvalidArrayException;
import com.meli.simios.util.FormatUtil;
import com.meli.simios.util.MatrixSequenceUtil;
import com.meli.simios.util.ValidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SimianService {

    private final int QT_MAX_SEQUENCE_SIMIAN = 4;

    private final Set ALLOWED_LETTERS = new HashSet<>(Arrays.asList("A", "G", "C", "T"));

    @Autowired
    private ValidUtil validUtil;

    @Autowired
    private FormatUtil formatUtil;

    @Autowired
    private DnaService dnaService;

    @Autowired
    private MatrixSequenceUtil matrixSequenceUtil;

    public Boolean isSimian(String[] dna) throws DnaInvalidException, InvalidArrayException {

        validUtil.validArray(dna);

        String[][] formattedDna = formatUtil.formatToBidimensionalSimianDna(dna);

        this.validSimianDna(formattedDna);

        dnaService.saveIfUniqueDna(formattedDna);

        return matrixSequenceUtil.getAllSequences(formattedDna, QT_MAX_SEQUENCE_SIMIAN) > 0;

    }

    public StatsDto getStats() {

        List<Dna> DNAs = dnaService.findAll();

        int count_simian_dna = 0, count_human_dna = 0;

        for (Dna dna : DNAs) {
            int qt_sequences = matrixSequenceUtil.getAllSequences(dna.getDna(), QT_MAX_SEQUENCE_SIMIAN);
            if (qt_sequences > 0) {
                count_simian_dna++;
            } else {
                count_human_dna++;
            }
        }

        StatsDto statsDto = new StatsDto();
        statsDto.setCount_human_dna(count_human_dna);
        statsDto.setCount_mutant_dna(count_simian_dna);
        if (statsDto.getCount_human_dna() > 0) {
            statsDto.setRatio(statsDto.getCount_mutant_dna()/statsDto.getCount_human_dna());
        } else {
            statsDto.setRatio(statsDto.getCount_mutant_dna());
        }

        return statsDto;

    }

    private void validSimianDna(String[][] dna) throws DnaInvalidException {

        for (int i=0; i < dna.length; i++) {
            for (int k=0; k < dna.length; k++) {
                if (!ALLOWED_LETTERS.contains(dna[i][k])) {
                    throw new DnaInvalidException();
                }
            }
        }

    }

}
