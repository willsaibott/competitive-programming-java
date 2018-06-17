package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimzations balanced the most I can.
 */
class Main555 {

    static HashMap<Character, Integer> map = new HashMap<>();
    static HashMap<Character, Integer> indexMap = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;

        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);
        map.put('T', 10);
        map.put('J', 11);
        map.put('Q', 12);
        map.put('K', 14);
        map.put('A', 15);
        map.put('C', 0);
        map.put('D', 1);
        map.put('S', 2);
        map.put('H', 3);
        indexMap.put('S', 0);
        indexMap.put('W', 1);
        indexMap.put('N', 2);
        indexMap.put('E', 3);

        while ((line = bf.readLine()) != null && !line.equals("#")) {
            StringBuilder sb = new StringBuilder();
            int dealer = indexMap.get(line.charAt(0));
            Player[] players = new Player[4];

            players[0] = new Player("S");
            players[1] = new Player("W");
            players[2] = new Player("N");
            players[3] = new Player("E");

            sb.append(bf.readLine()).append(bf.readLine());

            int ii = (dealer + 1);
            for (int jj = 0; jj < sb.length(); jj+= 2)
            {
                players[ii%4].addCard(sb.substring(jj, jj + 2));
                ii++;
            }

            for(Player player : players){
                System.out.println(player.getCards());
            }
        }
    }

    static class Player
    {
        private ArrayList<String> cards = new ArrayList<>();
        private String name;
        boolean sorted = false;

        Player(String name) {
            this.name = name;
        }

        public void addCard(String card)
        {
            cards.add(card);
            sorted = false;
        }

        public String getCards() {

            StringBuilder builder = new StringBuilder();
            if (!sorted)
            {
                sorted = true;

                Collections.sort(cards, new Comparator<String>() {
                    @Override
                    public int compare(String c1, String c2) {
                        int diff1 = map.get(c1.charAt(0)) - map.get(c2.charAt(0));
                        int diff2 = map.get(c1.charAt(1)) - map.get(c2.charAt(1));
                        return (diff1 != 0) ? diff1 : diff2;
                    }
                });
            }

            for (String card : cards) {
                builder.append(card + " ");
            }

            return this.getName() + ": " + builder.toString().trim();
        }

        public String getName() {
            return name;
        }
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA555 {

    final static String packName = UVA555.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA555.class, chapter);
        Main555.main(args);
    }

}