package com.wip._1._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

import static com.wip.Utils.defineInputMethod;



/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimzations balanced the most I can.
 * The class should have name Main in order to be submitted.
 */
class Main462{

    public static void main(String[] args) throws IOException
    {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;

        int k = 0;
        while ((line = bf.readLine()) != null) {
            String[] cards = line.split(" ");
            Suit[] suits = new Suit[4];

            suits[0] = new Suit('S');
            suits[1] = new Suit('H');
            suits[2] = new Suit('D');
            suits[3] = new Suit('C');

            for (String card : cards)
            {
                int index = Suit.getSuitIndex(card.charAt(1));
                suits[index].addCard(card.charAt(0));
            }

            SuitEvals suitEvals = new SuitEvals(suits);

            String output = "PASS";

            if (suitEvals.getEval() == 2)
            {
                output = "BID NO-TRUMP";
            }
            else if (suitEvals.getEval() == 1)
            {
                output = "BID " + suitEvals.getSuit().getSuitName();
            }

            System.out.println(output);
        }
    }

    static class SuitEvals
    {
        private int eval = 0;
        private int index = 0;
        private Suit[] suits;

        public SuitEvals(Suit[] suits) {
            int count = 4;
            this.suits = suits;
            int scoreNoTrump = 0;
            int scoreBid = 0;
            int maxSize = 0;

            for (int ii = 0; ii < suits.length; ii++)
            {
                suits[ii].evaluate();
                scoreNoTrump += suits[ii].getScoreNoTrump();
                scoreBid += suits[ii].getScore();

                if (suits[ii].isStopped())
                    count--;

                int size = suits[ii].getCards().size();
                if (size > maxSize)
                {
                    maxSize = size;
                    index = ii;
                }
            }

            if (scoreNoTrump >= 16 && count == 0)
            {
                eval = 2;
            }
            else if (scoreBid >= 14)
            {
                eval = 1;
            }
        }

        public int getEval()
        {
            return eval;
        }

        public Suit getSuit() {
            return suits[index];
        }
    }

    static class Suit
    {
        private char suit;
        private LinkedList<Character> cards = new LinkedList<>();
        private int scoreNoTrump = 0;
        private int scoreBid = 0;
        private int index;
        private boolean stopped = false;

        public boolean isStopped() {
            return stopped;
        }

        public Suit(char suit) {
            this.suit = suit;
            this.index = Suit.getSuitIndex(suit);
        }

        public LinkedList<Character> getCards() {
            return cards;
        }

        public void addCard(char card)
        {
            cards.add(card);
        }

        public char getSuitName() {
            return suit;
        }

        public int getScore() {
            return scoreBid;
        }

        public int getScoreNoTrump() {
            return scoreNoTrump;
        }

        public void evaluate()
        {
            int count = 0;
            int length = cards.size();

            for (char c : cards)
            {
                count += getValue(c, length);

                stopped = stopped ||
                          c == 'A' ||
                          (c == 'K' && length > 1) ||
                          (c == 'Q' && length > 2) ;
            }

            scoreNoTrump = count;
            scoreBid = count;


            if (length == 2)
            {
                scoreBid++;
            } else if (length <= 1)
            {
                scoreBid += 2;
            }
        }

        private int getValue(char c, int length)
        {
            int value = 0;

            switch (c)
            {
                case 'A':
                    value= 4;
                    break;
                case 'K':
                    value=3 - (length == 1 ? 1 : 0);
                    break;
                case 'Q':
                    value=2 - (length <= 2  ? 1 : 0);
                    break;
                case 'J':
                    value=1 - (length <= 3 ? 1 : 0);
                    break;
                default: value=0; break;


            }

            return value;
        }

        public static int getSuitIndex(char c)
        {
            switch (c)
            {
                case 'S': return 0;
                case 'H': return 1;
                case 'D': return 2;
                case 'C': return 3;
                default: return -1;
            }
        }

        public int getIndex() {
            return index;
        }
    }
}


/**
 * In order to submit it in uva judge platform, remove the public modifier from the
 * class declaration, rename the class to Main and remove the package declaration
 */
public class UVA462 {

    final static String packName = UVA462.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 4).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA462.class, chapter);
        Main462.main(args);
    }

}