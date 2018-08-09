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
class Main12279 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String line;

        int k = 0, threats, n;
        while ((line = bf.readLine()) != null && !line.equals("0")) {
            threats = 0;
            st = new StringTokenizer(bf.readLine());

            while (st.hasMoreTokens())
            {
                if ( Integer.parseInt(st.nextToken()) > 0)
                {
                    threats++;
                }
                else
                {
                    threats--;
                }
            }

            sb.append("Case ")
              .append(++k)
              .append(": ")
              .append(threats)
              .append("\n");
        }

        System.out.write(sb.toString().getBytes());
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA12279 {

    final static String packName = UVA12279.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA12279.class, chapter);
        Main12279.main(args);
    }
}