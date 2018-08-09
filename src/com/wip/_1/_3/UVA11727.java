package com.wip._1._3;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main11727 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String line;
        boolean begin = true;

        int k = 0, a, b, c, out;
        int testCases = Integer.parseInt(bf.readLine());
        while ((k++ < testCases) && (line = bf.readLine()) != null) {
            st = new StringTokenizer(line);

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if ((a > b && a < c) || (a > c && a < b))
            {
                out = a;
            } else if ((b > a && b < c) || (b > c && b < a))
            {
                out = b;
            } else
            {
                out = c;
            }

            sb.append("Case ")
              .append(k)
              .append(": ")
              .append(out)
              .append("\n");
        }

        System.out.write(sb.toString().getBytes());
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA11727 {

    final static String packName = UVA11727.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA11727.class, chapter);
        Main11727.main(args);
    }
}

