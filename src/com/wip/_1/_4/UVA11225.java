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
class Main11225 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;
        boolean begin = true;

        int k = 0;
        int testCases = Integer.parseInt(bf.readLine());
        while (k < testCases && (line = bf.readLine()) != null) {
            int nCards = Integer.parseInt(line);
            String[] cards = new String[nCards];
            String output  = "";
            int oudlers = 0;
            double rest = 0;
            double score = 0;

            for (int ii = 0; ii < nCards; ii++)
            {
                cards[ii] = bf.readLine().split(" ")[0];
                score += getValue(cards[ii]);

                if (cards[ii].equals("fool") ||
                    cards[ii].equals("twenty-one") ||
                    cards[ii].equals("one"))
                {
                    oudlers++;
                }
            }

            switch (oudlers)
            {
                case 1:
                    rest = score - 51;
                    break;
                case 2:
                    rest = score - 41;
                    break;
                case 3:
                    rest = score - 36;
                    break;
                default:
                    rest = score - 56;
                    break;
            }


            if (rest >= 0)
            {
                output = "Game won by " + (int) rest + " point(s).";
            }
            else
            {
                output = "Game lost by " + (int) -rest + " point(s).";
            }

            if (!begin) System.out.println();
            begin = false;

            System.out.println("Hand #" + ++k);
            System.out.println(output);
        }
    }


    static double getValue(String card)
    {
        switch (card)
        {
            case "king":
            case "fool":
            case "twenty-one":
            case "one":
                return 4.5;
            case "queen":
                return 3.5;
            case "knight":
                return 2.5;
            case "jack":
                return 1.5;
            default:
                return 0.5;
        }
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA11225 {

    final static String packName = UVA11225.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA11225.class, chapter);
        Main11225.main(args);
    }
}