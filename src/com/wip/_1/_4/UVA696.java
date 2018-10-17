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
class Main696 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;

        while ((line = bf.readLine()) != null && !line.equals("0 0")) {
            int rows, columns;
            int result;
            int max;

            st = new StringTokenizer(line);

            rows = Integer.parseInt(st.nextToken());
            columns = Integer.parseInt(st.nextToken());

            if (rows == 1 || columns == 1)
            {
                result = rows * columns;
            }
            else if (columns == 2 || rows == 2)
            {
                max = (Math.max(rows, columns));
                result = ((max - 1)/ 4  + 1) * 4 - (max % 4 == 1 ? 2 : 0);
            }
            else
            {
                result = rows * columns / 2 + ((rows & 1) & (columns & 1));
            }

            System.out.write((result + " knights may be placed on a " + rows + " row " + columns + " column board.\n").getBytes());
        }
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA696 {

    final static String packName = UVA696.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA696.class, chapter);
        Main696.main(args);
    }
}