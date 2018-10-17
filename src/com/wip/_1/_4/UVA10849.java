package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main10849 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;

        int k = 0;
        int testCases = Integer.parseInt(bf.readLine());
        while ((line = bf.readLine()) != null) {
            int tests = Integer.parseInt(bf.readLine());
            int n = Integer.parseInt(bf.readLine());

            for (int ii = 0; ii < tests; ii++)
            {
                String output = "no move";

                st = new StringTokenizer(bf.readLine());

                Point p0 = new Point(Integer.parseInt(st.nextToken()),
                                     Integer.parseInt(st.nextToken()));
                Point p1 = new Point(Integer.parseInt(st.nextToken()),
                                     Integer.parseInt(st.nextToken()));

                if (isMovePossible(p0, p1))
                {
                    output = "" + ((p0.equals(p1)) ?
                                   (0) :
                                   (Math.abs(p0.x - p1.x) == Math.abs(p0.y - p1.y) ? 1 : 2));
                }

                System.out.println(output);
            }
        }
    }

    static boolean isMovePossible(Point p0, Point p1)
    {
        return ((p0.x + p0.y) & 1) == ((p1.x  + p1.y ) & 1);
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA10849 {

    final static String packName = UVA10849.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA10849.class, chapter);
        Main10849.main(args);
    }
}