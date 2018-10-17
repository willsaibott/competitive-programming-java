package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main333 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        boolean correct;
        int[] input = new int[80];
        int[] s1    = new int[80];
        int[] s2    = new int[80];
        char[] inputc;
        int size;

        while ((line = bf.readLine()) != null) {
            sb.append(line.trim()).append(" is ");
            inputc = line.toCharArray();
            size = 0;
            correct = true;

            for (char c : inputc)
            {
                if (c >= '0' && c <= '9' )
                {
                    input[size++] = c - '0';
                } else if (c == 'X' && size == 9)
                {
                    input[size++] = 10;
                }
                else if (!Character.isSpaceChar(c) && c != '-')
                {
                    correct = false;
                    break;
                }

                if (size >= 11) break;
            }

            if (correct = (size == 10 && correct))
            {
                checkISBN(input, s1, size);
                checkISBN(s1, s2, size);
                correct = ((s2[size - 1] % 11) == 0);
            }

            if (!correct) sb.append("in");
            sb.append("correct.\n");
        }

        System.out.write(sb.toString().getBytes());
    }

    static void checkISBN(int[] v1, int[] v2, int size)
    {
        v2[0] = v1[0];

        for (int ii = 1; ii < size; ii++) {
            v2[ii] = v2[ii -1] + v1[ii];
        }
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA333 {

    final static String packName = UVA333.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA333.class, chapter);
        Main333.main(args);
    }
}