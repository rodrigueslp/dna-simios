package com.meli.simios.service;

import com.meli.simios.enumerator.DnaTypeEnum;
import com.meli.simios.enumerator.QtMatrixSequenceEnum;
import com.meli.simios.exception.DnaInvalidException;
import com.meli.simios.exception.InvalidArrayException;
import com.meli.simios.util.FormatUtil;
import com.meli.simios.util.MatrixSequenceUtil;
import com.meli.simios.util.ValidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;

@Service
public class SimianService {

    private final Set ALLOWED_LETTERS = new HashSet<>(Arrays.asList("A", "G", "C", "T"));

    @Autowired
    private ValidUtil validUtil;

    @Autowired
    private FormatUtil formatUtil;

    @Autowired
    private DnaService dnaService;

    @Autowired
    private MatrixSequenceUtil matrixSequenceUtil;

    public Boolean isSimian(String[] dna) throws DnaInvalidException, InvalidArrayException, ExecutionException, InterruptedException {

        validUtil.validArray(dna);

        String[][] formattedDna = formatUtil.formatToBidimensionalSimianDna(dna);

        this.validSimianDna(formattedDna);

        Boolean isSimian = matrixSequenceUtil.getAllSequences(formattedDna, QtMatrixSequenceEnum.QT_MAX_SEQUENCE_SIMIAN.getQtMaxSequence()) > 0;

        DnaTypeEnum dnaTypeEnum = isSimian ? DnaTypeEnum.MUTANT : DnaTypeEnum.HUMAN;

        dnaService.saveIfUniqueDna(formattedDna, dnaTypeEnum);

        return isSimian;

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
