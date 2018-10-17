package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main11945 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        double money, average;

        int k = 0;
        int testCases = Integer.parseInt(bf.readLine());
        while (k++ < testCases) {

            money = 0;
            for (int ii = 0; ii < 12; ii++) {
                money += Double.parseDouble(bf.readLine());
            }

            average = money / 12;

            sb.append(k)
              .append(" $")
              .append(String.format("%,.2f\n", average));
        }

        System.out.write(sb.toString().getBytes());
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA11945 {

    final static String packName = UVA11945.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA11945.class, chapter);
        Main11945.main(args);
    }
}