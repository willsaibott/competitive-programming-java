package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main12195 {
    static HashMap<Character, Integer> noteMap = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String line;
        String[] measures;
        int duration, corrects;

        createMap();


        while ((line = bf.readLine()) != null && !line.equals("*")) {
            measures = line.split("/");
            corrects = 0;

            for (String measure : measures) {
                duration = 0;
                for (char note : measure.toCharArray())
                {
                    duration += noteMap.get(note);
                }

                if (duration == 64) corrects++;
            }

            sb.append(corrects).append("\n");
        }

        System.out.write(sb.toString().getBytes());
    }

    private static void createMap()
    {
        noteMap.put('W', 64);
        noteMap.put('H', 32);
        noteMap.put('Q', 16);
        noteMap.put('E', 8);
        noteMap.put('S', 4);
        noteMap.put('T', 2);
        noteMap.put('X', 1);
    }

}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA12195 {

    final static String packName = UVA12195.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA12195.class, chapter);
        Main12195.main(args);
    }
}