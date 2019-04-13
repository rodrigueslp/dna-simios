package com.meli.simios.business;

import com.meli.simios.exception.DnaInvalidException;
import com.meli.simios.util.FormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class SimianBusiness {

    private final int SIMIAN_SEQUENCE = 4;

    private final Set ALLOWED_LETTERS = new HashSet<>(Arrays.asList("A", "G", "C", "T"));

    @Autowired
    private FormatUtil formatUtil;

    public Boolean isSimian(String[] dna) throws DnaInvalidException {

        if (dna == null || dna.length < 1) {
            // TO DO THROW INVALIDARGUMENTEXCEPTION
        }

        String[][] formattedDna = formatUtil.formatToBidimensionalSimianDna(dna);

        this.isDnaValid(formattedDna);

        return (this.getVerticalSimianDna(formattedDna) + this.getSimianDnaHorizontal(formattedDna)
                + this.getSimianDnaMainDiagonal(formattedDna) + this.getSimianDnaSecondaryDiagonal(formattedDna)) > 0;


    }

    private int getVerticalSimianDna(String[][] dna) {

        int countSequence = 1;
        int countDnaSimio = 0;
        String lastLetter = "";
        String currentLetter;

        for (int i = 0; i < dna.length; i++) {
            for (int k = 0; k < dna[i].length; k++) {
                if (k > 0) {
                    currentLetter = dna[i][k];
                    if (lastLetter.equals(currentLetter)) {
                        countSequence++;
                    } else {
                        countSequence = 1;
                    }
                } else {
                    currentLetter = dna[i][k];
                }
                lastLetter = currentLetter;
                if (countSequence == SIMIAN_SEQUENCE) {
                    countDnaSimio++;
                }
            }
            countSequence = 1;
        }

        return countDnaSimio;

    }

    private int getSimianDnaHorizontal(String[][] dna) {

        int countSequence = 1;
        int countDnaSimio = 0;
        String lastLetter = "";
        String currentLetter;

        for (int i = 0; i < dna.length; i++) {
            for (int k = 0; k < dna[i].length; k++) {
                if (k > 0) {
                    currentLetter = dna[k][i];
                    if (lastLetter.equals(currentLetter)) {
                        countSequence++;
                    } else {
                        countSequence = 1;
                    }
                } else {
                    currentLetter = dna[k][i];
                }
                lastLetter = currentLetter;
                if (countSequence == SIMIAN_SEQUENCE) {
                    countDnaSimio++;
                }
            }
            countSequence = 1;
        }

        return countDnaSimio;

    }

    private int getSimianDnaMainDiagonal(String[][] dna) {

        int countSequence = 1;
        int countDnaSimio = 0;
        String lastLetter = "";
        String currentLetter;

        for (int i = 0; i < dna.length; ++i) {

            for (int j = 0; j < dna.length - i; ++j) {
                currentLetter = dna[j][j+i];
                if (lastLetter.equals(currentLetter)) {
                    countSequence++;
                }

                if (countSequence == SIMIAN_SEQUENCE) {
                    countDnaSimio++;
                    countSequence = 1;
                }
                lastLetter = currentLetter;
            }

            countSequence = 1;


            if (i != 0) {

                lastLetter = "";

                for (int j = 0; j < dna.length - i; ++j) {
                    currentLetter = dna[j+i][j];
                    if (lastLetter.equals(currentLetter)) {
                        countSequence++;
                    }

                    if (countSequence == SIMIAN_SEQUENCE) {
                        countDnaSimio++;
                        countSequence = 1;
                    }
                    lastLetter = currentLetter;
                }

                countSequence = 1;

            }

        }

        return countDnaSimio;

    }

    private int getSimianDnaSecondaryDiagonal(String[][] dna) {

        int countSequence = 1;
        int countDnaSimio = 0;
        String lastLetter = "";
        String currentLetter = "";

        for (int c = 1; c <= dna.length; c++) {
            for (int i = 0; i < dna.length; i++) {
                for (int k = 0; k < (dna.length); k++) {
                    if (i + k == (dna.length - c)) {
                        currentLetter = dna[i][k];

                        if (lastLetter.equals(currentLetter)) {
                            countSequence++;
                        }

                        if (countSequence == SIMIAN_SEQUENCE) {
                            countDnaSimio++;
                            countSequence = 1;
                        }
                        lastLetter = currentLetter;

                    }
                }
            }

            countSequence = 1;

            for (int i = 0; i < dna.length; i++) {
                for (int k = 0; k < (dna.length); k++) {
                    if (i + k == (dna.length + (c-1))) {

                        currentLetter = dna[i][k];

                        if (lastLetter.equals(currentLetter)) {
                            countSequence++;
                        }

                        if (countSequence == SIMIAN_SEQUENCE) {
                            countDnaSimio++;
                            countSequence = 1;
                        }
                        lastLetter = currentLetter;

                    }
                }
            }

            countSequence = 1;

        }

        return countDnaSimio;

    }

    private void isDnaValid(String[][] dna) throws DnaInvalidException {

        for (int i=0; i < dna.length; i++) {
            for (int k=0; k < dna.length; k++) {
                if (!ALLOWED_LETTERS.contains(dna[i][k])) {
                    throw new DnaInvalidException();
                }
            }
        }

    }



}
