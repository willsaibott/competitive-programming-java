package com.wip._1._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.wip.Utils.defineInputMethod;

/**
 * In order to submit it in uva judge platform, remove the public modifier from the
 * class declaration, rename the class to Main and remove the package declaration
 */
public class UVA11687 {
    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA11687.class);

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String x0 ;
        while ((x0 = bf.readLine()) != null && !x0.equals("END")) {
            int ii = 1;
            String xi = String.valueOf(x0.length());

            while (!xi.equals(x0)) {
                ii++;
                x0 = xi;
                xi = String.valueOf(x0.length());
            }

            System.out.println(ii);
        }

    }
}
