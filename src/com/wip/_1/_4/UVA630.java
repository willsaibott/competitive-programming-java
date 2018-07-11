package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main630 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String line, key;
        boolean begin = true;
        HashMap<String, ArrayList<String>> dictionary = new HashMap<>();

        int k = 0;
        int testCases = Integer.parseInt(bf.readLine());
        while ((k++ < testCases) && (line = bf.readLine()) != null) {
            int size = Integer.parseInt(bf.readLine());
            ArrayList<String> list;
            dictionary.clear();

            // Build dictionary
            for (int ii = 0; ii < size; ii++) {
                line = bf.readLine();
                key = getKey(line);

                if ((list = dictionary.get(key)) != null)
                {
                    list.add(line);
                }
                else
                {
                    list = new ArrayList<String>();
                    list.add(line);
                    dictionary.put(key, list);
                }
            }

            if (!begin) sb.append("\n");
            begin = false;

            while ((line = bf.readLine()) != null && !line.equals("END"))
            {
                key = getKey(line);
                sb.append("Anagrams for: ").append(line).append("\n");

                if ((list = dictionary.get(key)) != null)
                {
                    for (int ii = 0; ii < list.size(); ii++) {
                        sb.append("  ").append(ii+1).append(") ").append(list.get(ii)).append("\n");
                    }
                }
                else
                {
                    sb.append("No anagrams for: ").append(line).append("\n");
                }
            }
        }

        System.out.write(sb.toString().getBytes());
    }

    public static String getKey(String word)
    {
        char[] sorted = word.toCharArray();
        Arrays.sort(sorted);
        return new String(sorted);
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA630 {

    final static String packName = UVA630.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA630.class, chapter);
        Main630.main(args);
    }
}