package com.wip._1._3;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import javax.swing.text.html.parser.Entity;

import static com.wip.Utils.defineInputMethod;
import static java.lang.System.exit;
import static java.lang.System.setIn;
import static java.lang.System.setOut;

/**
 * In order to submit it in uva judge platform, remove the public modifier from the
 * class declaration, rename the class to Main and remove the package declaration
 */
public class IOI2010_memory {
    static char[] card = new char[51];
    static int[]  up = new int [2], is_up = new int[51], candy = new int[25];
    static int candies, moves;

    public static void main(String[] args) {
        defineInputMethod(args);

        playgame();

        System.out.println(moves);
    }

    static char faceup(int C){
        int c0, c1;
        if (C < 1 || C > 50 || is_up[C] > 0) {
            exit(91);
        }
        is_up[C] = 1;
        up[moves%2] = C;
        moves++;
        if (moves%2 == 0) {
            c0 = card[ up[0] ] - 'A';
            c1 = card[ up[1] ] - 'A';
            if (c0==c1 && candy[c0] == 0 ) {
                candy[c0] = 1;
                ++candies;
            }
            is_up[ up[0] ] = is_up[ up[1] ] = 0;
        }
        return card[C];
    }

    static void playgame(){
        Scanner scanner = new Scanner(System.in);
        int i;
        while (scanner.hasNext()) {
            card = (" " + scanner.nextLine()).toCharArray();
            moves = candies = 0;
            play();
            if (candies != 25) {
                exit(91);
            }
        }
    }

    private static void play() {
        HashMap<Character, Card> map = new HashMap<>();
        for (int ii = 1; ii < 51; ii++) {

            int before = candies;
            char c = faceup(ii);
            int after = candies;

            Card card = map.get(c);
            if (after == before) {
                if (card != null) {
                    card.set(ii);
                } else {
                    map.put(c, new Card(ii));
                }
            } else {
                map.remove(c);
            }
        }

        for (Entry<Character, Card> entry : map.entrySet()) {
            faceup(entry.getValue().getP1());
            faceup(entry.getValue().getP2());
        }
    }


    static class Card {
        private int p1 = -1, p2 = -1;

        public Card(int position) {
            p1 = position;
        }

        public int getP1() {
            return p1;
        }

        public int getP2() {
            return p2;
        }

        void set(int position) {
            p2 = position;
        }
    }

}
