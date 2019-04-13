package com.meli.simios.util;

import org.springframework.stereotype.Component;

@Component
public class FormatUtil {

    public String[][] formatToBidimensionalSimianDna(String[] arrayUnidimensional) {
        String arrayBidimensional[][] = new String[arrayUnidimensional[0].length()][arrayUnidimensional[0].length()];

        for (int i = 0; i < arrayUnidimensional.length; i++) {
            char[] arrDna = arrayUnidimensional[i].toCharArray();
            for (int k = 0; k < arrDna.length; k++) {
                arrayBidimensional[i][k] = String.valueOf(arrDna[k]);
            }
        }

        return arrayBidimensional;

    }

}
