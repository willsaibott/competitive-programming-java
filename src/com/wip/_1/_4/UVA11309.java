package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main11309 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;

        int k = 0;
        int testCases = Integer.parseInt(bf.readLine());
        while ((k++ < testCases) && (line = bf.readLine()) != null && !line.equals("0")) {
            int hour = Integer.parseInt(line.substring(0, 2));
            int min = Integer.parseInt(line.substring(3, 5));

            sb.append(getNextPalindrome(hour, min));
        }

        System.out.write(sb.toString().getBytes());
    }

    private static String getNextPalindrome(int hour, int min)
    {
        String next;
        StringBuilder sb = new StringBuilder();
        int number;

        do
        {
            min++;
            if (min >= 60)
            {
                min = 0;
                hour++;
                if (hour >= 24)
                {
                    hour = 0;
                    break;
                }
            }

            number = hour * 100 + min;
        }while (!isPalindrome(number));

        next = sb.append(String.format("%02d:%02d", hour, min))
                 .append("\n")
                 .toString();

        return next;
    }

    public static boolean isPalindrome(int number)
    {
        int reverse = 0;
        int original = number;

        while (number != 0)
        {
            reverse = reverse * 10;
            reverse += number % 10;
            number /= 10;
        }
        return reverse == original && reverse != 0;
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA11309 {

    final static String packName = UVA11309.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA11309.class, chapter);
        Main11309.main(args);
    }
}