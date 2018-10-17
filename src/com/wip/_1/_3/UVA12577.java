package com.wip._1._3;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main12577 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;

        int k = 0;
        while ((line = bf.readLine()) != null && !line.equals("*")) {
            sb.append("Case ")
              .append(++k)
              .append(": ");

            if ("Hajj".equals(line))
            {
                sb.append("Hajj-e-Akbar\n");
            }
            else
            {
                sb.append("Hajj-e-Asghar\n");
            }
        }

        System.out.write(sb.toString().getBytes());
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA12577 {

    final static String packName = UVA12577.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA12577.class, chapter);
        Main12577.main(args);
    }
}