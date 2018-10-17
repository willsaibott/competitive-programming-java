package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main353 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = bf.readLine()) != null) {
            HashSet<String> palindrome = new HashSet<>();
            int offset;
            int length = line.length();
            String substr;

            for (int ii = 1; ii <= length; ii++)
            {
                offset = 0;
                while (offset + ii <= length) {
                    substr = line.substring(offset, offset + ii);

                    if (!palindrome.contains(substr) && isPalindrome(substr)) {
                        palindrome.add(substr);
                    }
                    offset++;
                }
            }

            sb.append("The string '")
              .append(line)
              .append("' contains ")
              .append(palindrome.size())
              .append(" palindromes.\n");
        }

        System.out.write(sb.toString().getBytes());
    }

    public static boolean isPalindrome(String substr)
    {
        char[] sub, comp;
        int limit = (substr.length()) / 2 + (substr.length() & 1);
        comp = sub = substr.toCharArray();

        for (int jj = 0; jj < limit; jj++) {
            if (comp[jj] != sub[sub.length - (jj + 1)]) {
                return false;
            }
        }

        return true;
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA353 {

    final static String packName = UVA353.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA353.class, chapter);
        Main353.main(args);
    }
}