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
class Main10530 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;
        boolean eof = false;

        while (!eof) {
            String output = "Stan may be honest";
            int max = 10;
            int min = 1;
            boolean won = false;

            while (!won && !(eof = (line = bf.readLine()) == null || line.equals("0")))
            {
                int guess = Integer.parseInt(line);
                String feedback = bf.readLine();

                switch (feedback)
                {
                    case "too high":
                        max = Math.min(guess - 1, max);
                        break;
                    case "too low":
                        min = Math.max(min, guess + 1);
                        break;
                    case "right on":
                        won = true;
                        if (guess < min || guess > max)
                            output = "Stan is dishonest";
                        break;
                }
            }

            if (!eof)
            {
                System.out.println(output);
            }
        }
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA10530 {

    final static String packName = UVA10530.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA10530.class, chapter);
        Main10530.main(args);
    }
}