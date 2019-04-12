package com.meli.simios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimiosApplication {

    public static void main(String[] args) {

        SpringApplication.run(SimiosApplication.class, args);

        /*int contIguais = 1;
        int contSimio = 0;
        String ultimaLetra = "";
        String atualLetra = "";

        String[][] matriz = {
                {"C", "C", "C", "C", "G", "A"},
                {"C", "G", "T", "C", "G", "C"},
                {"A", "A", "C", "T", "T", "T"},
                {"A", "C", "A", "C", "T", "G"},
                {"C", "A", "A", "A", "T", "T"},
                {"T", "C", "A", "A", "T", "G"}
        };

        for (int i = 0; i < matriz.length; i++) {
            for (int k = 0; k < matriz[i].length; k++) {
                if (k > 0) {
                    atualLetra = matriz[i][k];
                    if (ultimaLetra.equals(atualLetra)) {
                        contIguais++;
                    } else {
                        contIguais = 1;
                    }
                } else {
                    atualLetra = matriz[i][k];
                }
                ultimaLetra = atualLetra;
                if (contIguais == 4) {
                    contSimio++;
                }
            }
            contIguais = 1;
        }

        System.out.println("Número de sequencias simios HORIZONTAL: " + contSimio);

        contIguais = 1;
        contSimio = 0;
        ultimaLetra = "";
        atualLetra = "";

        for (int i = 0; i < matriz.length; i++) {
            for (int k = 0; k < matriz[i].length; k++) {
                if (k > 0) {
                    atualLetra = matriz[k][i];
                    if (ultimaLetra.equals(atualLetra)) {
                        contIguais++;
                    } else {
                        contIguais = 1;
                    }
                } else {
                    atualLetra = matriz[k][i];
                }
                ultimaLetra = atualLetra;
                if (contIguais == 4) {
                    contSimio++;
                }
            }
            contIguais = 1;
        }

        System.out.println("Número de sequencias simios VERTICAL: " + contSimio); */

        /*String[][] matriz = {
                {"C", "C", "C", "C", "G", "A"},
                {"C", "G", "T", "C", "A", "C"},
                {"A", "A", "C", "A", "T", "T"},
                {"A", "C", "A", "C", "T", "G"},
                {"C", "A", "A", "A", "T", "T"},
                {"T", "C", "A", "A", "T", "G"}
        };

        int contIguais = 1;
        int contSimio = 0;
        String ultimaLetra = "";
        String atualLetra = "";

        for (int c = 1; c <= matriz.length; c++) {
            for (int i = 0; i < matriz.length; i++) {
                for (int k = 0; k < (matriz.length); k++) {
                    if (i + k == (matriz.length - c)) {
                        System.out.print("([" + i + "," + k + "])");
                        System.out.println(matriz[i][k]);

                        atualLetra = matriz[i][k];

                        if (ultimaLetra.equals(atualLetra)) {
                            contIguais++;
                        }

                        if (contIguais == 4) {
                            contSimio++;
                            contIguais = 1;
                        }
                        ultimaLetra = atualLetra;

                    }
                }
            }

            contIguais = 1;
            System.out.println();

            for (int i = 0; i < matriz.length; i++) {
                for (int k = 0; k < (matriz.length); k++) {
                    if (i + k == (matriz.length + (c-1))) {
                        System.out.print("([" + i + "," + k + "])");
                        System.out.println(matriz[i][k]);

                        atualLetra = matriz[i][k];

                        if (ultimaLetra.equals(atualLetra)) {
                            contIguais++;
                        }

                        if (contIguais == 4) {
                            contSimio++;
                            contIguais = 1;
                        }
                        ultimaLetra = atualLetra;

                    }
                }
            }

            contIguais = 1;

            System.out.println();

        }
        System.out.println("Número de sequencias simios DIAGONAL SECUNDÁRIA: " + contSimio);*/

//        System.out.println("+++++++++++++++++++++++++++++++++++++++++");

        /*for (int c = 0; c < tamMatriz; c++) {
            for (int i = 0; i < tamMatriz; i++) {
                for (int k = 0; k < (tamMatriz); k++) {
                    if (i + k == (tamMatriz + c)) {
                        System.out.print("([" + i + "," + k + "])");
                        System.out.println(matriz[i][k]);
                    }
                }
            }
            System.out.println();
        }*/





        /*for (int i = 0; i < matriz.length; ++i) {

            System.out.print("\nDiagonal PRIMEIRA : \n");

            for (int j = 0; j < matriz.length - i; ++j) {
                atualLetra = matriz[j][j+i];
                if (ultimaLetra.equals(atualLetra)) {
                    contIguais++;
                }
                System.out.print("([" + j + "," + (j + i) + "])");
                System.out.println(matriz[j][j+i]);
                if (contIguais == 4) {
                    contSimio++;
                    contIguais = 1;
                }
                ultimaLetra = atualLetra;
            }

            contIguais = 1;


            if (i != 0) {
                ultimaLetra = "";
                atualLetra = "";
                System.out.print("\nDiagonal SEGUNDA : \n");
                for (int j = 0; j < matriz.length - i; ++j) {
                    atualLetra = matriz[j+i][j];
                    if (ultimaLetra.equals(atualLetra)) {
                        contIguais++;
                    }
                    System.out.print("([" + (j + i) + "," + j + "])");
                    System.out.println(matriz[j+i][j]);
                    if (contIguais == 4) {
                        contSimio++;
                        contIguais = 1;
                    }
                    ultimaLetra = atualLetra;
                }
                contIguais = 1;
            }
        }

		System.out.println("Número de sequencias simios DIAGONAL: " + contSimio);*/

    }


}
