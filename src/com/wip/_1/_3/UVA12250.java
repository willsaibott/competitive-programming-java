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
class Main12250 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String line, output;
        boolean begin = true;

        int k = 0;
        while ((line = bf.readLine()) != null && !line.equals("#")) {

            switch (line)
            {
                case "HELLO":        output = "ENGLISH"; break;
                case "HOLA":         output = "SPANISH"; break;
                case "HALLO":        output = "GERMAN"; break;
                case "BONJOUR":      output = "FRENCH"; break;
                case "ZDRAVSTVUJTE": output = "RUSSIAN"; break;
                case "CIAO":         output = "ITALIAN"; break;
                default:             output = "UNKNOWN"; break;
            }

            sb.append("Case ")
              .append(++k)
              .append(": ")
              .append(output)
              .append("\n");
        }

        System.out.write(sb.toString().getBytes());
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA12250 {

    final static String packName = UVA12250.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA12250.class, chapter);
        Main12250.main(args);
    }
}
