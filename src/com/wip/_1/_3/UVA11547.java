package com.wip._1._3;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main11547 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String line;
        boolean begin = true;

        int k = 0;
        int testCases = Integer.parseInt(bf.readLine());
        while ((k++ < testCases) && (line = bf.readLine()) != null) {
            long n = Integer.parseInt(line);
            long out = Math.abs(((n * 567l / 9l + 7492l) * 235l / 47l - 498l) / 10) % 10;

            sb.append(out).append("\n");
        }

        System.out.write(sb.toString().getBytes());
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA11547 {

    final static String packName = UVA11547.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA11547.class, chapter);
        Main11547.main(args);
    }
}