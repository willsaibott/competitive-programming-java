package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main10903 {

    public final static String SCISSORS = "scissors";
    public final static String ROCK = "rock";
    public final static String PAPER = "paper";

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;
        StringBuilder sb = new StringBuilder();
        boolean begin = true;
        DecimalFormat df = new DecimalFormat("0.000");

        while ((line = bf.readLine()) != null && !line.equals("0")) {
            int[] wins, losses;
            int players, times, total;
            int p1, p2, result;
            String m1, m2;

            st = new StringTokenizer(line);
            players = Integer.parseInt(st.nextToken());
            times = Integer.parseInt(st.nextToken());
            total = times * players * (players - 1) / 2;
            wins = new int[players];
            losses = new int[players];

            if (!begin) sb.append("\n");
            begin = false;

            for (int ii = 0; ii < total; ii++)
            {
                st = new StringTokenizer(bf.readLine());
                p1 = Integer.parseInt(st.nextToken()) - 1;
                m1 = st.nextToken();
                p2 = Integer.parseInt(st.nextToken()) - 1;
                m2 = st.nextToken();

                result = play(m1, m2);

                if (result == 1)
                {
                    wins[p1]++;
                    losses[p2]++;
                } else if (result == 2)
                {
                    losses[p1]++;
                    wins[p2]++;
                }
            }

            double average;

            for (int ii = 0; ii < players; ii++) {
                average = ((double)wins[ii])/((double)wins[ii] + (double) losses[ii]);
                sb.append(Double.isNaN(average) ? "-" : df.format(average)).append("\n");
            }
        }

        System.out.write(sb.toString().getBytes());
    }

    public static int play(String m1, String m2)
    {
        if (m1.equals(m2)) return 0;
        if (m1.equals(ROCK) && m2.equals(SCISSORS) ||
            m1.equals(SCISSORS) && m2.equals(PAPER) ||
            m1.equals(PAPER) && m2.equals(ROCK))
        {
            return 1;
        }

        return 2;
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA10903 {

    final static String packName = UVA10903.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA10903.class, chapter);
        Main10903.main(args);
    }
}