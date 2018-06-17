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
class Main11494 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;

        while ((line = bf.readLine()) != null && !line.equals("0 0 0 0")) {
            String output = "0";
            Point p0, p1;

            st = new StringTokenizer(line);

            p0 = new Point(Integer.parseInt(st.nextToken()),
                           Integer.parseInt(st.nextToken()));

            p1 = new Point(Integer.parseInt(st.nextToken()),
                           Integer.parseInt(st.nextToken()));

            if (!p0.equals(p1))
            {
                output = (isOneMove(p0, p1)) ? "1" : "2";
            }

            System.out.println(output);
        }
    }

    static boolean isOneMove(Point p0, Point p1)
    {
        return ((Math.abs(p0.x - p1.x) == Math.abs(p0.y - p1.y)) ||
                (p0.x == p1.x) ||
                (p0.y == p1.y));
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA11494 {

    final static String packName = UVA11494.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA11494.class, chapter);
        Main11494.main(args);
    }
}