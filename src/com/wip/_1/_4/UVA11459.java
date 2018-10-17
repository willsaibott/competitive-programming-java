package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main11459 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;

        int k = 0;
        int testCases = Integer.parseInt(bf.readLine());
        while (k++ < testCases && (line = bf.readLine()) != null) {
            String base = "Position of player ";
            String output;
            int players, nLadders, rolls, player = 0;
            int[] tokens;
            int[] die;
            HashMap<Integer, Integer> ladders = new HashMap<>();
            boolean gameOver = false;
            Integer jump;

            st = new StringTokenizer(line);
            players = Integer.parseInt(st.nextToken());
            nLadders = Integer.parseInt(st.nextToken());
            rolls   = Integer.parseInt(st.nextToken());

            tokens  = new int[players];
            die     = new int[rolls];

            for (int ii = 0; ii < nLadders; ii++) {
                st = new StringTokenizer(bf.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                ladders.put(start, end);
            }

            for (int ii = 0; ii < rolls; ii++) {
                die[ii] = Integer.parseInt(bf.readLine());

                if(!gameOver)
                {
                    tokens[player] += die[ii];

                    if ((jump = ladders.get(tokens[player] + 1)) != null)
                    {
                        tokens[player] = jump - 1;
                    }

                    if (tokens[player] >= 99)
                    {
                        tokens[player] = 99;
                        gameOver = true;
                        continue;
                    }

                    player = (player + 1) % players;
                }
            }

            for (int ii = 0; ii < players; ii++) {
                System.out.println(base + (ii + 1) +  " is " + (tokens[ii] + 1) + ".");
            }
        }
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA11459 {

    final static String packName = UVA11459.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA11459.class, chapter);
        Main11459.main(args);
    }
}