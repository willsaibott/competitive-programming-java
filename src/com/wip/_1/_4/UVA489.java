package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main489 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;

        while ((line = bf.readLine()) != null && !line.equals("-1"))
        {
            String output = "You chickened out.";
            String word = bf.readLine();
            char[] guess = bf.readLine().toCharArray();
            HashSet<Character> guessSet = new HashSet<>();
            HashSet<Character> wordSet = new HashSet<>();
            int chances = 7;

            for (int ii = 0; ii < word.length(); ii++)
            {
                wordSet.add(word.charAt(ii));
            }

            for (char c : guess)
            {
                if (wordSet.remove(c))
                {
                    if (wordSet.isEmpty())
                    {
                        output = "You win.";
                        break;
                    }
                }
                else if (guessSet.add(c))
                {
                    chances--;

                    if (chances <=  0)
                    {
                        output = "You lose.";
                        break;
                    }
                }
            }

            System.out.println("Round " + line);
            System.out.println(output);
        }
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA489 {

    final static String packName = UVA489.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA489.class, chapter);
        Main489.main(args);
    }
}