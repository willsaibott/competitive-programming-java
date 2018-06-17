package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimzations balanced the most I can.
 */
class Main12247 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;

        while ((line = bf.readLine()) != null && !line.equals("0 0 0 0 0")) {
            int output = 53;
            int[] sister = new int[3];
            int[] brother = new int[2];
            long deck = 0;

            st = new StringTokenizer(line);
            for (int ii = 0; ii < 3; ii++ )
            {
                sister[ii] = Integer.parseInt(st.nextToken());
                deck = deck | (1l << (sister[ii] - 1));
            }

            for (int ii = 0; ii < 2; ii++ )
            {
                brother[ii] = Integer.parseInt(st.nextToken());
                deck = deck | (1l << (brother[ii] - 1));
            }

            Arrays.sort(sister);
            Arrays.sort(brother);

            // Both cards are higher than the sister's
            if (brother[0] > sister[2])
            {
                output = 1;
                while ((deck & (1l << (output - 1))) != 0)
                    output++;
            }
            // At least one of the cards is higher than all of the sister's
            else if (brother[1] > sister[2])
            {
                output = sister[2] + 1;
                while (output < 53 && ((deck & (1l << (output - 1))) != 0))
                    output++;
            }

            // Both cards are higher than at least 2 of sister's
            if (brother[0] > sister[1])
            {
                int index = sister[1] + 1;
                while (index < 53 && ((deck & (1l << (index - 1))) != 0))
                    index++;

                output = Math.min(output, index);

            }

            if (output >= 53)
                output = -1;
            System.out.println(output);
        }
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA12247 {

    final static String packName = UVA12247.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA12247.class, chapter);
        Main12247.main(args);
    }
}