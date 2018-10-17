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
class Main947 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;

        int k = 0;
        int testCases = Integer.parseInt(bf.readLine());
        while (k++ < testCases && (line = bf.readLine()) != null && !line.equals("0")) {
            st = new StringTokenizer(line);

            String guess = st.nextToken();
            int strong = Integer.parseInt(st.nextToken());
            int weak = Integer.parseInt(st.nextToken());
            int count = generateCodes(guess, strong, weak);


            System.out.println(count);
        }

    }

    private static int generateCodes(String guess, int strong, int weak)
    {
        HashSet<String> codes = new HashSet<>();
        String minStr = "11";
        int guessInt = Integer.parseInt(guess);
        int length = guess.length();
        int max = (int)Math.pow(10, length) - 1;
        HashSet<Integer> s = new HashSet();
        HashSet<Integer> w = new HashSet();
        int[] occur;

        if (length == strong)
        {
            return 1;
        }

        while (minStr.length() < length)
        {
            minStr += "1";
        }

        for (int ii = Integer.parseInt(minStr); ii <= max; ii++)
        {
            int code = ii;
            int digit = 0;
            int pos = length - 1;
            int guessIntCopy = guessInt;

            occur = new int[10];
            s.clear();
            w.clear();

            while (code > 0)
            {
                digit = code % 10;
                if (digit == 0) break;
                occur[digit]++;
                code /= 10;
            }
            if (digit == 0) continue;

            code = ii;

            while (code > 0 && pos >= 0)
            {
                digit = code % 10;
                if (digit == guess.charAt(pos) - '0') {
                    occur[digit]--;
                    s.add(pos);
                }
                code /= 10;
                pos--;
            }

            pos = length - 1;
            while (guessIntCopy > 0 && pos >= 0)
            {
                digit = guessIntCopy % 10;
                if(occur[digit] > 0)
                {
                    if (!w.contains(pos) && !s.contains(pos)) {
                        w.add(pos);
                        occur[digit]--;
                    }
                }
                pos--;
                guessIntCopy /= 10;
            }

            if (s.size() == strong && w.size() == weak)
            {
                codes.add("" + ii);
            }
        }

        return codes.size();
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA947 {

    final static String packName = UVA947.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA947.class, chapter);
        Main947.main(args);
    }
}