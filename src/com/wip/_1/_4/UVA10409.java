package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main10409 {

    static int[] north = { 2, 1, 4, 3, 5, 0 };
    static int[] south = { 5, 1, 0, 3, 2, 4 };
    static int[] west  = { 0, 2, 3, 5, 4, 1 };
    static int[] east  = { 0, 5, 1, 2, 4, 3 };

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;

        while ((line = bf.readLine()) != null && !line.equals("0")) {
            int n = Integer.parseInt(line);
            int[] die = { 2, 3, 1, 4, 5, 6 };

            for (int ii = 0; ii < n; ii++) {
                String command = bf.readLine();
                int[] new_die = new int[6];
                int[] swap;

                switch (command)
                {
                    case "north":
                        swap = north;
                        break;
                    case "south":
                        swap = south;
                        break;
                    case "east":
                        swap = east;
                        break;
                    case "west":
                        swap = west;
                        break;
                    default:
                        throw new RuntimeException("Invalid Input command");
                }

                for (int jj = 0; jj < 6; jj++) {
                    new_die[jj] = die[swap[jj]];
                }

                die = new_die;
            }

            System.out.println(die[2]);
        }
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA10409 {

    final static String packName = UVA10409.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA10409.class, chapter);
        Main10409.main(args);
    }
}