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
class Main11984 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String line;

        int k = 0;
        int testCases = Integer.parseInt(bf.readLine());
        double celcius, fahrenheit, increase;

        while ((k++ < testCases) && (line = bf.readLine()) != null) {
            st = new StringTokenizer(line);

            celcius  = Integer.parseInt(st.nextToken());
            increase = Integer.parseInt(st.nextToken());

            fahrenheit = celciusToFahrenheit(celcius) + increase;

            sb.append("Case ")
              .append(k)
              .append(": ")
              .append(String.format("%.2f", fahrenheitToCelcius(fahrenheit)))
              .append("\n");
        }

        System.out.write(sb.toString().getBytes());
    }

    static double celciusToFahrenheit(double celcius)
    {
        return (9.0 / 5.0) * celcius + 32.0;
    }

    static double fahrenheitToCelcius(double fahrenheit)
    {
        return (fahrenheit - 32.0) * (5.0 / 9.0);
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA11984 {

    final static String packName = UVA11984.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA11984.class, chapter);
        Main11984.main(args);
    }
}