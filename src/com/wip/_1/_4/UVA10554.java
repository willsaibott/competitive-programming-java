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
class Main10554 {

    static int[] caloriesMap = { 9, 4, 4, 4, 7 };
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String line;
        boolean begin = true;
        double total = 0, calories = 0;
        double subTotal,  percentages, value;
        String[] inputs;
        String input;
        char last;

        while ((line = bf.readLine()) != null) {
            if (line.equals("-"))
            {
                if (total > 0)
                {
                    sb.append(Math.round(100.0 * calories / total)).append("%\n");
                }
                total = calories = 0;
            }
            else
            {
                subTotal = percentages = 0;
                inputs = line.split(" ");

                for (int ii = 0; ii < inputs.length; ii++)
                {
                    input = inputs[ii];
                    last = input.charAt(input.length() -1);
                    value = Double.parseDouble(input.substring(0, input.length() - 1));

                    if (last == 'g')
                    {
                        subTotal += caloriesMap[ii] * value;
                    } else if (last == '%')
                    {
                        percentages += value;
                    }
                    else
                    {
                        subTotal += value;
                    }
                }

                subTotal = subTotal * 100.0 / (100.0 - percentages);
                total += subTotal;

                input = inputs[0];
                last = input.charAt(input.length() -1);
                value = Double.parseDouble(input.substring(0, input.length() - 1));

                if (last == 'g')
                {
                    calories += caloriesMap[0] * value;
                } else if (last == '%')
                {
                    calories += value / 100.0 * subTotal;
                }
                else
                {
                    calories += value;
                }

            }
        }

        System.out.write(sb.toString().getBytes());
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA10554 {

    final static String packName = UVA10554.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA10554.class, chapter);
        Main10554.main(args);
    }
}