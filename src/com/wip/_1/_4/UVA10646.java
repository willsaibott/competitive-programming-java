package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimzations balanced the most I can.
 */
class Main10646 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;

        int k = 0;
        int testCases = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        while ((line = bf.readLine()) != null)
            sb.append(line + "\n ");

        String input = sb.toString();
        st = new StringTokenizer(input);

        while (k < testCases && st.hasMoreTokens()) {
            Stack<String> pile = new Stack<>();
            LinkedList<String> hand = new LinkedList<String>();
            int y = 0;

            for (int ii = 0; ii < 52; ii++) {
                pile.push(st.nextToken());
            }

            for (int ii = 0; ii < 25; ii++) {
                hand.add(pile.pop());
            }

            for (int ii = 0; ii < 3; ii++) {
                int x = getValue(pile.pop());

                y += x;

                int jj = x;
                while (10 - jj++ > 0) pile.pop();
            }

            for (int ii = 0; ii < 25; ii++) {
                pile.push(hand.removeLast());
            }

            String output = pile.elementAt(y - 1);
            System.out.printf("Case %d: %s\n", ++k, output);
        }
    }

    static int getValue(String card)
    {
        int value = 0;
        char c = card.charAt(0);

        if (c >= '2' && c <= '9') value = c - '0';
        else value = 10;
        return value;
    }
}

class Main10646_2 {
    public static void main (String[]args) throws IOException  {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount=Integer.parseInt(br.readLine());
        for (int testCase=1;testCase<=testCaseCount;testCase++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            LinkedList<String> cardValue=new LinkedList<> ();
            while (st.hasMoreTokens()) {
                String s=st.nextToken();
                cardValue.addFirst(s);
            }

            LinkedList<String> topCards=new LinkedList<>();
            for (int i=0;i<25;i++) {
                topCards.addLast(cardValue.removeFirst());
            }

            int Y=0;
            for (int loopC=0;loopC<3;loopC++) {
                int X=0;
                String s=cardValue.removeFirst();
                if (Character.isDigit(s.charAt(0))) {
                    X=s.charAt(0)-'0';
                } else {
                    X=10;
                }
                Y+=X;
                for (int i=0;i<10-X;i++) {
                    cardValue.removeFirst();
                }
            }

            for (int i=0;i<25;i++) {
                cardValue.addFirst(topCards.removeLast());
            }

            StringBuilder sb=new StringBuilder("Case ");
            sb.append(testCase);
            sb.append(": ");
            sb.append(cardValue.get(cardValue.size()-Y));
            System.out.println(sb.toString());
        }

    }
}


/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA10646 {

    final static String packName = UVA10646.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA10646.class, chapter);
        Main10646.main(args);
    }
}