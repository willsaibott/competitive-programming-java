package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main10945 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String line;

        while ((line = bf.readLine()) != null && !line.equals("DONE")) {
            line = line.toLowerCase().replaceAll("(\\.|,|\\s|!|\\?)", "");
            String reverse = (new StringBuilder(line)).reverse().toString();

            if (reverse.equals(line))
            {
                sb.append("You won't be eaten!\n");
            }
            else
            {
                sb.append("Uh oh..\n");
            }
        }

        System.out.write(sb.toString().getBytes());
    }
}


/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA10945 {

    final static String packName = UVA10945.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA10945.class, chapter);
        Main10945.main(args);
    }
}