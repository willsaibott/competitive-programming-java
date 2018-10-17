package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main340 {

    static int sum = 0;
    static int[] occur;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line;

        int k = 0;
        while ((line = bf.readLine()) != null && !line.equals("0")) {
            int length = Integer.parseInt(line);
            String codeLine = bf.readLine();
            String output = "Game " + ++k + ":";
            int[] code = readCode(codeLine, length);
            int[] guess;

            System.out.println(output);

            occur = new int[10];
            for (int ii : code) {
                occur[ii]++;
            }

            while ((guess = readCode(bf.readLine(), length)).length > 0 && (sum != 0))
            {
                HashSet<Integer> strong = new HashSet();
                HashSet<Integer> weak = new HashSet();

                int[] occurCopy = Arrays.copyOf(occur, 10);

                for (int ii = 0; ii < length; ii++)
                {
                    if (guess[ii] == code[ii])
                    {
                        strong.add(ii);
                        occurCopy[guess[ii]]--;
                    }
                }

                for (int jj = 0; jj < length; jj++)
                {
                    if(occurCopy[guess[jj]] > 0)
                    {
                        if (!weak.contains(jj) && !strong.contains(jj)) {
                            weak.add(jj);
                            occurCopy[guess[jj]]--;
                        }
                    }
                }

                System.out.println("    (" + strong.size() + "," + weak.size() + ")");
            }
        }
    }

    static int[] readCode(String codeLine, int length)
    {
        StringTokenizer st = new StringTokenizer(codeLine);
        int[] code = new int[length];
        sum = 0;

        for (int ii = 0; ii < length; ii++) {
            code[ii] = Integer.parseInt(st.nextToken());
            sum += code[ii];
        }

        return code;
    }
}


/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA340 {

    final static String packName = UVA340.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA340.class, chapter);
        Main340.main(args);
    }
}