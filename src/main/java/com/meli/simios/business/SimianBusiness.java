package com.meli.simios.business;

import org.springframework.stereotype.Component;

@Component
public class SimianBusiness {

    final int SEQUENCE_TO_SIMIAN = 4;

    public Boolean isSimian(String[][] dna) {

        return (getSimianDnaVertical(dna) + getSimianDnaHorizontal(dna) + getSimianDnaMainDiagonal(dna) + getSimianDnaSecondaryDiagonal(dna)) > 0;

    }

    private int getSimianDnaVertical(String[][] dna) {

        int contIguais = 1;
        int contSimio = 0;
        String ultimaLetra = "";
        String atualLetra = "";

        for (int i = 0; i < dna.length; i++) {
            for (int k = 0; k < dna[i].length; k++) {
                if (k > 0) {
                    atualLetra = dna[i][k];
                    if (ultimaLetra.equals(atualLetra)) {
                        contIguais++;
                    } else {
                        contIguais = 1;
                    }
                } else {
                    atualLetra = dna[i][k];
                }
                ultimaLetra = atualLetra;
                if (contIguais == SEQUENCE_TO_SIMIAN) {
                    contSimio++;
                }
            }
            contIguais = 1;
        }

        return contSimio;

    }

    private int getSimianDnaHorizontal(String[][] dna) {

        int contIguais = 1;
        int contSimio = 0;
        String ultimaLetra = "";
        String atualLetra = "";

        for (int i = 0; i < dna.length; i++) {
            for (int k = 0; k < dna[i].length; k++) {
                if (k > 0) {
                    atualLetra = dna[k][i];
                    if (ultimaLetra.equals(atualLetra)) {
                        contIguais++;
                    } else {
                        contIguais = 1;
                    }
                } else {
                    atualLetra = dna[k][i];
                }
                ultimaLetra = atualLetra;
                if (contIguais == SEQUENCE_TO_SIMIAN) {
                    contSimio++;
                }
            }
            contIguais = 1;
        }

        return contSimio;

    }

    private int getSimianDnaMainDiagonal(String[][] dna) {

        int contIguais = 1;
        int contSimio = 0;
        String ultimaLetra = "";
        String atualLetra = "";

        for (int i = 0; i < dna.length; ++i) {

            for (int j = 0; j < dna.length - i; ++j) {
                atualLetra = dna[j][j+i];
                if (ultimaLetra.equals(atualLetra)) {
                    contIguais++;
                }

                if (contIguais == SEQUENCE_TO_SIMIAN) {
                    contSimio++;
                    contIguais = 1;
                }
                ultimaLetra = atualLetra;
            }

            contIguais = 1;


            if (i != 0) {
                ultimaLetra = "";
                atualLetra = "";

                for (int j = 0; j < dna.length - i; ++j) {
                    atualLetra = dna[j+i][j];
                    if (ultimaLetra.equals(atualLetra)) {
                        contIguais++;
                    }

                    if (contIguais == SEQUENCE_TO_SIMIAN) {
                        contSimio++;
                        contIguais = 1;
                    }
                    ultimaLetra = atualLetra;
                }
                contIguais = 1;
            }
        }

        return contSimio;

    }

    private int getSimianDnaSecondaryDiagonal(String[][] dna) {

        int contIguais = 1;
        int contSimio = 0;
        String ultimaLetra = "";
        String atualLetra = "";

        for (int c = 1; c <= dna.length; c++) {
            for (int i = 0; i < dna.length; i++) {
                for (int k = 0; k < (dna.length); k++) {
                    if (i + k == (dna.length - c)) {
                        atualLetra = dna[i][k];

                        if (ultimaLetra.equals(atualLetra)) {
                            contIguais++;
                        }

                        if (contIguais == SEQUENCE_TO_SIMIAN) {
                            contSimio++;
                            contIguais = 1;
                        }
                        ultimaLetra = atualLetra;

                    }
                }
            }

            contIguais = 1;

            for (int i = 0; i < dna.length; i++) {
                for (int k = 0; k < (dna.length); k++) {
                    if (i + k == (dna.length + (c-1))) {

                        atualLetra = dna[i][k];

                        if (ultimaLetra.equals(atualLetra)) {
                            contIguais++;
                        }

                        if (contIguais == SEQUENCE_TO_SIMIAN) {
                            contSimio++;
                            contIguais = 1;
                        }
                        ultimaLetra = atualLetra;

                    }
                }
            }

            contIguais = 1;

        }

        return contSimio;

    }

}
