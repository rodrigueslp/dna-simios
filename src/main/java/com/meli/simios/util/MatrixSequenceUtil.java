package com.meli.simios.util;

import org.springframework.stereotype.Component;

@Component
public class MatrixSequenceUtil {

    public int getAllSequences(String[][] matrix, int qtdMaxLettersSequence) {
        int allSequences = this.getHorizontalSequence(matrix, qtdMaxLettersSequence)
                + this.getVerticalSequence(matrix, qtdMaxLettersSequence)
                + this.getMainDiagonalSequence(matrix, qtdMaxLettersSequence)
                + this.getSecondaryDiagonalSequence(matrix, qtdMaxLettersSequence);
        return allSequences;
    }

    public int getVerticalSequence(String[][] matrix, int qtdMaxLettersSequence) {

        int countEqualLetters = 1;
        int countSequence = 0;
        String lastLetter = "";
        String currentLetter;

        for (int i = 0; i < matrix.length; i++) {
            for (int k = 0; k < matrix[i].length; k++) {
                if (k > 0) {
                    currentLetter = matrix[i][k];
                    if (lastLetter.equals(currentLetter)) {
                        countEqualLetters++;
                    } else {
                        countEqualLetters = 1;
                    }
                } else {
                    currentLetter = matrix[i][k];
                }
                lastLetter = currentLetter;
                if (countEqualLetters == qtdMaxLettersSequence) {
                    countSequence++;
                }
            }
            countEqualLetters = 1;
        }

        return countSequence;

    }

    public int getHorizontalSequence(String[][] matrix, int qtdMaxLettersSequence) {

        int countEqualLetters = 1;
        int countSequence = 0;
        String lastLetter = "";
        String currentLetter;

        for (int i = 0; i < matrix.length; i++) {
            for (int k = 0; k < matrix[i].length; k++) {
                if (k > 0) {
                    currentLetter = matrix[k][i];
                    if (lastLetter.equals(currentLetter)) {
                        countEqualLetters++;
                    } else {
                        countEqualLetters = 1;
                    }
                } else {
                    currentLetter = matrix[k][i];
                }
                lastLetter = currentLetter;
                if (countEqualLetters == qtdMaxLettersSequence) {
                    countSequence++;
                }
            }
            countEqualLetters = 1;
        }

        return countSequence;

    }

    public int getMainDiagonalSequence(String[][] matrix, int qtdMaxLettersSequence) {

        int countEqualLetters = 1;
        int countSequence = 0;
        String lastLetter = "";
        String currentLetter;

        for (int i = 0; i < matrix.length; ++i) {

            for (int j = 0; j < matrix.length - i; ++j) {
                currentLetter = matrix[j][j+i];
                if (lastLetter.equals(currentLetter)) {
                    countEqualLetters++;
                }

                if (countEqualLetters == qtdMaxLettersSequence) {
                    countSequence++;
                    countEqualLetters = 1;
                }
                lastLetter = currentLetter;
            }

            countEqualLetters = 1;


            if (i != 0) {

                lastLetter = "";

                for (int j = 0; j < matrix.length - i; ++j) {
                    currentLetter = matrix[j+i][j];
                    if (lastLetter.equals(currentLetter)) {
                        countEqualLetters++;
                    }

                    if (countEqualLetters == qtdMaxLettersSequence) {
                        countSequence++;
                        countEqualLetters = 1;
                    }
                    lastLetter = currentLetter;
                }

                countEqualLetters = 1;

            }

        }

        return countSequence;

    }

    public int getSecondaryDiagonalSequence(String[][] matrix, int qtdMaxLettersSequence) {

        int countEqualLetters = 1;
        int countSequence = 0;
        String lastLetter = "";
        String currentLetter = "";

        for (int c = 1; c <= matrix.length; c++) {
            for (int i = 0; i < matrix.length; i++) {
                for (int k = 0; k < (matrix.length); k++) {
                    if (i + k == (matrix.length - c)) {
                        currentLetter = matrix[i][k];

                        if (lastLetter.equals(currentLetter)) {
                            countEqualLetters++;
                        }

                        if (countEqualLetters == qtdMaxLettersSequence) {
                            countSequence++;
                            countEqualLetters = 1;
                        }
                        lastLetter = currentLetter;

                    }
                }
            }

            countEqualLetters = 1;

            for (int i = 0; i < matrix.length; i++) {
                for (int k = 0; k < (matrix.length); k++) {
                    if (i + k == (matrix.length + (c-1))) {

                        currentLetter = matrix[i][k];

                        if (lastLetter.equals(currentLetter)) {
                            countEqualLetters++;
                        }

                        if (countEqualLetters == qtdMaxLettersSequence) {
                            countSequence++;
                            countEqualLetters = 1;
                        }
                        lastLetter = currentLetter;

                    }
                }
            }

            countEqualLetters = 1;

        }

        return countSequence;

    }



}
