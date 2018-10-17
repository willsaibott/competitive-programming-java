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
class Main10812 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String line;
        String impossible = "impossible\n";

        int k = 0;
        int testCases = Integer.parseInt(bf.readLine());
        int sum, diff, a, b;

        while ((k++ < testCases) && (line = bf.readLine()) != null) {
            st   = new StringTokenizer(line);
            sum  = Integer.parseInt(st.nextToken());
            diff = Integer.parseInt(st.nextToken());

//            sum == (a + (diff + a));
//            sum == diff + 2a;

            a = (sum - diff) / 2;
            b = diff + a;

            if (a >= 0 && ((a + b) == sum))
            {
                sb.append(b).append(" ").append(a).append("\n");
            }
            else
            {
                sb.append(impossible);
            }
        }

        System.out.write(sb.toString().getBytes());
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA10812 {

    final static String packName = UVA10812.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA10812.class, chapter);
        Main10812.main(args);
    }
}