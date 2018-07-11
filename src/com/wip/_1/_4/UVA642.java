package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main642 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line, key;
        HashMap<String, ArrayList<String>> dictionary = new HashMap<>();
        ArrayList<String> list;

        while ((line = bf.readLine()) != null && !line.equals("XXXXXX"))
        {
            key = getKey(line);
            if ((list = dictionary.get(key)) != null)
            {
                list.add(line);
            }
            else
            {
                list = new ArrayList<>();
                list.add(line);
                dictionary.put(key, list);
            }
        }

        while ((line = bf.readLine()) != null && !line.equals("XXXXXX"))
        {
            key = getKey(line);
            if ((list = dictionary.get(key)) != null)
            {
                Collections.sort(list);

                for (String word : list) {
                    sb.append(word).append("\n");
                }
            }
            else
            {
                sb.append("NOT A VALID WORD\n");
            }

            sb.append("******\n");
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
public class UVA642 {

    final static String packName = UVA642.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA642.class, chapter);
        Main642.main(args);
    }
}