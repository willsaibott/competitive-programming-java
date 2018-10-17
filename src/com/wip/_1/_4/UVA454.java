package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main454 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String line, key;
        boolean begin = true;
        HashMap<String, ArrayList<String>> phrases = new HashMap<>();
        HashSet<String> outputSet = new HashSet<>();

        int k = 0;
        int testCases = Integer.parseInt(bf.readLine());

        bf.readLine(); // skip first blank line
        while ((k++ < testCases)) {
            phrases.clear();
            outputSet.clear();

            while ((line = bf.readLine()) != null && !line.equals(""))
            {
                ArrayList<String> list;
                key = getKey(line);

                if ((list = phrases.get(key)) != null)
                {
                    for (String phrase : list) {
                        if (phrase.compareTo(line) < 0)
                            outputSet.add(phrase + " = " + line);
                        else
                            outputSet.add(line + " = " + phrase);
                    }
                    list.add(line);
                }
                else
                {
                    list = new ArrayList<>();
                    list.add(line);
                    phrases.put(key, list);
                }
            }

            if (!begin) sb.append("\n");
            begin = false;

            String[] output = outputSet.toArray(new String[outputSet.size()]);

            Arrays.sort(output);

            for (String pair : output) {
                sb.append(pair).append("\n");
            }
        }

        System.out.write(sb.toString().getBytes());
    }

    public static String getKey(String phrase)
    {
        char[] sorted = phrase.replaceAll(" ", "").toCharArray();
        Arrays.sort(sorted);
        return new String(sorted);
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA454 {

    final static String packName = UVA454.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA454.class, chapter);
        Main454.main(args);
    }
}