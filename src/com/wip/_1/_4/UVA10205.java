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
class Main10205 {

    static String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
    static String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;

        int testCases = Integer.parseInt(bf.readLine());
        boolean isBegin = true;

        bf.readLine(); // skip blank line
        while ((line = bf.readLine()) != null)
        {
            int nSufflesKnown = Integer.parseInt(line);
            Shuffle[] shuffles = new Shuffle[nSufflesKnown + 1];
            StringBuilder sb = new StringBuilder();

            while ((line = bf.readLine()) != null && !line.equals(""))
                sb.append(line + " \n");

            String input = sb.toString();
            st = new StringTokenizer(input);

            for (int ii = 1; ii<= nSufflesKnown; ii++)
            {
                int[] deck = new int[52];
                for (int jj = 0; jj < 52; jj++)
                    deck[jj] = Integer.parseInt(st.nextToken());
                shuffles[ii] = new Shuffle(deck);
            }

            int[] cards = null;
            while (st.hasMoreTokens()){
                int id = Integer.parseInt(st.nextToken());
                cards = shuffles[id].execute(cards);
            }

            if (!isBegin)
            {
                System.out.println();
            }

            isBegin = false;

            for (int ii = 0; ii < 52; ii++) {
                int value = (cards[ii] - 1) % 13;
                int suit = (cards[ii] - 1) / 13 ;
                System.out.println(values[value] + " of " + suits[suit]);
            }
        }
    }

    static class Shuffle
    {
        private int[] pairs = new int[52];

        public Shuffle(int[] deck) {
            for (int ii = 0; ii< 52; ii++) {
                this.pairs[ii] = deck[ii] - 1;
            }
        }

        public int[] execute(int[] cards)
        {
            int[] newCards = new int[52];

            if (cards != null){
                for (int ii = 0; ii < 52; ii++)
                {
                    newCards[ii] = cards[pairs[ii]];
                }
            }
            else
            {
                for (int ii = 0; ii < 52; ii++)
                {
                    newCards[ii] = pairs[ii] + 1;
                }
            }

            return newCards;
        }

        public int[] getPairs() {
            return pairs;
        }
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA10205 {

    final static String packName = UVA10205.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA10205.class, chapter);
        Main10205.main(args);
    }

}