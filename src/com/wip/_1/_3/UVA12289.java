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
class Main12289 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String line;

        int k = 0;
        int testCases = Integer.parseInt(bf.readLine());
        while ((k++ < testCases) && (line = bf.readLine()) != null && !line.equals("0")) {

            if (line.length() == 5)
            {
                sb.append(3);
            }
            else
            {
                if ((line.charAt(0) == 't' && ((line.charAt(1) == 'w') || line.charAt(2) == 'o')) ||
                    (line.endsWith("wo")))
                {
                    sb.append(2);
                }
                else
                {
                    sb.append(1);
                }
            }

            sb.append("\n");
        }

        System.out.write(sb.toString().getBytes());
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA12289 {

    final static String packName = UVA12289.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA12289.class, chapter);
        Main12289.main(args);
    }
}