package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main156 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        String word, key;
        LinkedHashMap<String, String> dictionary = new LinkedHashMap<>();
        HashMap<String, String> relAnagrams = new HashMap<>();

        do {
            if (st == null || !st.hasMoreTokens())
            {
                st = new StringTokenizer(bf.readLine());
            }

            word = st.nextToken();
            key = getKey(word);

            if (dictionary.containsKey(key))
            {
                relAnagrams.remove(key);
            }
            else
            {
                dictionary.put(key, word);
                relAnagrams.put(key, word);
            }

        } while (!word.equals("#"));

        relAnagrams.remove("#");

        List<String> values = new ArrayList<>(relAnagrams.values());

        Collections.sort(values);

        for (String value : values) {
            sb.append(value).append("\n");
        }

        System.out.write(sb.toString().getBytes());
    }


    public static String getKey(String word)
    {
        char[] sorted = word.toLowerCase().toCharArray();
        Arrays.sort(sorted);
        return new String(sorted);
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA156 {

    final static String packName = UVA156.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA156.class, chapter);
        Main156.main(args);
    }
}