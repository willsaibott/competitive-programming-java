package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main10018 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;

        int k = 0;
        int testCases = Integer.parseInt(bf.readLine());
        while ((k++ < testCases) && (line = bf.readLine()) != null) {
            String number = line;
            long n, reverse, rounds = 0;

            do
            {
                n = Long.parseLong(number);
                reverse = Long.parseLong((new StringBuilder(number)).reverse().toString());
                number = "" + (n + reverse);
                rounds++;
            } while (!isPalindrome(number));

            sb.append(rounds)
              .append(" ")
              .append(number)
              .append("\n");
        }

        System.out.write(sb.toString().getBytes());
    }

    public static boolean isPalindrome(String number)
    {
        return number.equals((new StringBuilder(number)).reverse().toString());
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA10018 {

    final static String packName = UVA10018.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA10018.class, chapter);
        Main10018.main(args);
    }
}
