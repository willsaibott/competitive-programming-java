package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main12239 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;

        while ((line = bf.readLine()) != null && !line.equals("0 0")) {
            HashSet<Integer> possible = new HashSet<>();
            int n, b;
            int[] balls;
            st = new StringTokenizer(line);
            n = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            balls = new int[b];

            st = new StringTokenizer(bf.readLine());
            for (int ii = 0; ii < b; ii++) {
                balls[ii] = Integer.parseInt(st.nextToken());

                possible.add(balls[ii]);

                for (int jj = ii - 1; jj >= 0; jj--)
                {
                    possible.add(Math.abs(balls[ii] - balls[jj]));
                }
            }

            String output = (possible.size() == (n + 1)) ? "Y" : "N";
            System.out.println(output);
        }
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA12239 {

    final static String packName = UVA12239.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA12239.class, chapter);
        Main12239.main(args);
    }
}