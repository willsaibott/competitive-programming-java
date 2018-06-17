package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimzations balanced the most I can.
 */
class Main278 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;

        int k = 0;
        int testCases = Integer.parseInt(bf.readLine());
        while ((line = bf.readLine()) != null && !line.equals("0")) {
            char piece;
            int rows, columns;
            int result = 0;

            st = new StringTokenizer(line);

            piece = st.nextToken().charAt(0);
            rows = Integer.parseInt(st.nextToken());
            columns = Integer.parseInt(st.nextToken());

            switch (piece)
            {
                case 'r':
                    result = Math.min(rows, columns);
                    break;
                case 'k':
                    result = rows * columns / 2 + ((rows & 1) & (columns & 1));
                    break;
                case 'K':
                    int kr = rows / 2 + (rows & 1);
                    int kc = columns / 2 + (columns & 1);
                    result = kr * kc;
                    break;
                case 'Q':
                    result = Math.min(rows, columns);
                    break;
                default:
                    result = 0;
                    break;
            }

            System.out.println(result);
        }
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA278 {

    final static String packName = UVA278.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA278.class, chapter);
        Main278.main(args);
    }
}