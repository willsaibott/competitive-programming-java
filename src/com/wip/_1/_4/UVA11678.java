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
class Main11678 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;

        while ((line = bf.readLine()) != null && !line.equals("0 0")) {
            int a, b;
            int[] aCards, bCards;
            int[] changes = new int[2];

            st = new StringTokenizer(line);
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            aCards = new int[a];
            bCards = new int[b];

            st = new StringTokenizer(bf.readLine());

            for (int ii = 0; ii < a; ii++)
            {
                aCards[ii] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(bf.readLine());

            for (int jj = 0; jj < b; jj++)
            {
                bCards[jj] = Integer.parseInt(st.nextToken());

                if(Arrays.binarySearch(aCards, bCards[jj]) < 0 && (jj == 0 || bCards[jj] != bCards[jj - 1] ))
                    changes[1]++;
            }

            for (int ii = 0; ii < a; ii++)
            {
                if(Arrays.binarySearch(bCards, aCards[ii]) < 0 && (ii == 0 || aCards[ii] != aCards[ii - 1] ))
                    changes[0]++;
            }

            System.out.println(Math.min(changes[0], changes[1]));
        }
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA11678 {

    final static String packName = UVA11678.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA11678.class, chapter);
        Main11678.main(args);
    }
}