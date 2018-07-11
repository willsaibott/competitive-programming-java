package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main10098 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        boolean begin = true;
        HashSet<String> set;
        String[] list;

        int k = 0;
        int testCases = Integer.parseInt(bf.readLine());
        while ((k++ < testCases) && (line = bf.readLine()) != null) {
            getPermutationSet(line, sb);

            if (!begin) sb.append("\n");
            begin = false;
        }

        System.out.write(sb.append("\n").toString().getBytes());
    }

    public static HashSet<String> getPermutationSet(String word, StringBuilder sb)
    {
        HashSet<String> set = new HashSet<>();

        permute(set, word.toCharArray(), 0, word.length() - 1);

        return set;
    }

    private static void permute(HashSet<String> set, char[] word, int start, int end)
    {
        if (start >= end)
        {
            set.add(new String(word));
        }
        else
        {
            for (int ii = start; ii <= end; ii++)
            {
                if (!set.contains(swap(word, start, ii)))
                {
                    permute(set, word, start + 1, end);
                }
                swap(word, start, ii);
            }
        }
    }

    private static String swap(char[] word, int p1, int p2)
    {
        char temp = word[p1];
        word[p1] = word[p2];
        word[p2] = temp;
        return new String(word);
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA10098 {

    final static String packName = UVA10098.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA10098.class, chapter);
        Main10098.main(args);
    }
}