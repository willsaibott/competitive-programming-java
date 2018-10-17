package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;


/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimzations balanced the most I can.
 */
class Main10315 {

    static HashMap<Character, Integer> map = new HashMap<>();
    static char[] cardMap = { '\0', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;

        map.put('2', 1);
        map.put('3', 2);
        map.put('4', 3);
        map.put('5', 4);
        map.put('6', 5);
        map.put('7', 6);
        map.put('8', 7);
        map.put('9', 8);
        map.put('T', 9);
        map.put('J', 10);
        map.put('Q', 11);
        map.put('K', 12);
        map.put('A', 13);

        map.put('C', 0);
        map.put('D', 1);
        map.put('H', 2);
        map.put('S', 3);

        while ((line = bf.readLine()) != null) {
            String[] cards = line.split(" ");
            Score score1, score2;

            Hand[] hands = new Hand[2];

            hands[0] = new Hand(Arrays.copyOfRange(cards, 0, 5));
            hands[1] = new Hand(Arrays.copyOfRange(cards, 5, 10));

            score1 = hands[0].hasStraightFlush();
            score2 = hands[1].hasStraightFlush();

            if (isOver(score1, score2)) continue;

            score1 = hands[0].hasFourOfAKind();
            score2 = hands[1].hasFourOfAKind();

            if (isOver(score1, score2)) continue;

            score1 = hands[0].hasFullHouse();
            score2 = hands[1].hasFullHouse();

            if (isOver(score1, score2)) continue;

            score1 = hands[0].hasFlush();
            score2 = hands[1].hasFlush();

            if (isOver(score1, score2)) continue;

            score1 = hands[0].hasStraight();
            score2 = hands[1].hasStraight();

            if (isOver(score1, score2)) continue;

            score1 = hands[0].hasThreeOfAKind();
            score2 = hands[1].hasThreeOfAKind();

            if (isOver(score1, score2)) continue;


            score1 = hands[0].hasTwoPairs();
            score2 = hands[1].hasTwoPairs();

            if (isOver(score1, score2)) continue;

            score1 = hands[0].hasOnePair();
            score2 = hands[1].hasOnePair();

            if (isOver(score1, score2)) continue;

            score1 = hands[0].highestCard();
            score2 = hands[1].highestCard();

            if (isOver(score1, score2)) continue;
        }
    }

    private static boolean isOver(Score score1, Score score2) {
        int index = 0;
        boolean gameOver;

        if ((gameOver = (score1.hasValue || score2.hasValue)))
        {
            while (index < 5 && score1.values[index] == score2.values[index])
                index++;

            String output = (index == 5) ? "Tie." : (score1.values[index] > score2.values[index] ? "Black wins." : "White wins.");
            System.out.println(output);
        }


        return gameOver;
    }

    static class Hand
    {
        HashMap<Integer, ArrayList<Character>> occurMap = new HashMap<>();
        String[] cards;
        int[] occurrences = new int[14];
        int[] suites = new int[4];
        int[] values = new int[5];

        Hand(String[] cards)
        {
            this.cards = cards;

            occurMap.put(0, new ArrayList<>());
            occurMap.put(1, new ArrayList<>());
            occurMap.put(2, new ArrayList<>());
            occurMap.put(3, new ArrayList<>());
            occurMap.put(4, new ArrayList<>());

            Arrays.sort(cards, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    return map.get(s2.charAt(0)) - map.get(s1.charAt(0));
                }
            });

            for (int ii = 0; ii < cards.length; ii++)
            {
                char c0 = cards[ii].charAt(0);
                char c1 = cards[ii].charAt(1);

                occurrences[map.get(c0)]++;
                suites[map.get(c1)]++;
                values[ii] = map.get(c0);
            }

            for (int ii = 1; ii < 14; ii++)
            {
                if (occurrences[ii] > 0)
                {
                    occurMap.get(occurrences[ii]).add(cardMap[ii]);
                }
            }
        }

        Score hasStraightFlush()
        {
            Score flush = hasFlush();

            return (flush.hasValue && hasStraight().hasValue) ? flush : new Score();
        }

        Score hasFourOfAKind()
        {
            Score score = new Score();
            ArrayList<Character> list = occurMap.get(4);

            if (!list.isEmpty())
            {
                score.hasValue = true;
                score.values[0] = map.get(list.get(0));
                score.values[1] = map.get(occurMap.get(1).get(0));
            }

            return score;
        }

        Score hasFullHouse()
        {
            Score score = new Score();
            ArrayList<Character> pair = occurMap.get(2), triple = occurMap.get(3) ;

            if (!pair.isEmpty() && !triple.isEmpty())
            {
                score.hasValue = true;
                score.values[0] = map.get(triple.get(0));
                score.values[1] = map.get(pair.get(0));
            }

            return score;
        }

        Score hasFlush()
        {
            Score score = new Score(values);

            for (int suite : suites) {
                if (suite == 5)
                {
                    score.hasValue = true;
                    break;
                }
            }

            return score;
        }

        Score hasStraight()
        {
            Score score = new Score();
            score.hasValue = ((map.get(cards[0].charAt(0)) == map.get(cards[1].charAt(0)) + 1) &&
                              (map.get(cards[1].charAt(0)) == map.get(cards[2].charAt(0)) + 1) &&
                              (map.get(cards[2].charAt(0)) == map.get(cards[3].charAt(0)) + 1) &&
                              (map.get(cards[3].charAt(0)) == map.get(cards[4].charAt(0)) + 1));

            if (score.hasValue)
                score.values = values;
            return score;
        }

        Score hasThreeOfAKind()
        {
            Score score = new Score();
            ArrayList<Character> list = occurMap.get(3);

            if (!list.isEmpty())
            {
                score.hasValue = true;
                score.values[0] = map.get(list.get(0));
            }

            return  score;
        }

        Score hasTwoPairs()
        {
            Score score = new Score();
            ArrayList<Character> pairs = occurMap.get(2);

            if (pairs.size() == 2)
            {
                score.hasValue = true;
                score.values[0] = (map.get(pairs.get(0)) > map.get(pairs.get(1)) ?
                                   map.get(pairs.get(0)) :
                                   map.get(pairs.get(1)));
                score.values[1] = (map.get(pairs.get(0)) < map.get(pairs.get(1)) ?
                                   map.get(pairs.get(0)) :
                                   map.get(pairs.get(1)));

                score.values[2] = (map.get(occurMap.get(1).get(0)));
            }
            return score;
        }

        Score hasOnePair()
        {
            Score score = new Score();
            ArrayList<Character> pairs = occurMap.get(2);

            if (pairs.size() == 1)
            {
                score.hasValue = true;
                score.values[0] = map.get(pairs.get(0));

                int ii = 1;
                for (char c : occurMap.get(1))
                {
                    score.values[ii++] = map.get(c);
                }
            }
            return score;
        }

        Score highestCard()
        {
            Score score = new Score(values);

            score.hasValue = true;
            return score;
        }

    }

    static class Score
    {
        int[] values;

        Score(int[] values)
        {
            this.values = values;
        }

        Score()
        {
            this(new int[5]);
        }

        boolean hasValue = false;
    }

}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA10315 {

    final static String packName = UVA10315.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA10315.class, chapter);
        Main10315.main(args);
    }
}
