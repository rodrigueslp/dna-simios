package com.meli.simios.util;

import com.meli.simios.exception.MatrixNotSquareException;
import org.springframework.stereotype.Component;

@Component
public class FormatUtil {

    public String[][] formatToSquareBidimensional(String[] arrayUnidimensional) throws MatrixNotSquareException {

        String arrayBidimensional[][] = new String[arrayUnidimensional[0].length()][arrayUnidimensional[0].length()];

        for (int i = 0; i < arrayUnidimensional.length; i++) {
            char[] arrDna = arrayUnidimensional[i].toCharArray();

            if (arrayUnidimensional.length != arrDna.length) throw new MatrixNotSquareException();

            for (int k = 0; k < arrDna.length; k++) {
                arrayBidimensional[i][k] = String.valueOf(arrDna[k]);
            }

        }
        return arrayBidimensional;

    }

}
