package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main12555 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String line;
        DecimalFormat decimalFormat = new DecimalFormat("0.##");

        int k = 0;
        int testCases = Integer.parseInt(bf.readLine());
        int index;
        double a, b;


        while ((k++ < testCases) && (line = bf.readLine()) != null) {
            a = b = 0;

            for (index = 0; index < line.length(); index++) {
                char c = line.charAt(index);

                if (Character.isDigit(c)) {
                    a = a * 10 + (c - '0');
                } else {
                    break;
                }
            }

            for (; index < line.length(); index++) {
                char c = line.charAt(index);

                if (Character.isDigit(c)) {
                    b = b * 10 + (c - '0');
                }
            }

            a = a * 0.5 + b * 0.05;

            sb.append("Case ")
                    .append(k)
                    .append(": ")
                    .append(decimalFormat.format(a))
                    .append("\n");
        }

        System.out.write(sb.toString().getBytes());
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA12555 {

    final static String packName = UVA12555.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA12555.class, chapter);
        Main12555.main(args);
    }
}