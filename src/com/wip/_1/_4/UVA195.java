package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main195 {

    static int diff = Math.abs('A' - 'a');

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;

        int k = 0;
        int testCases = Integer.parseInt(bf.readLine());
        while ((k++ < testCases) && (line = bf.readLine()) != null) {
            HashSet<String> set = getPermutationSet(line);
            String[] words = set.toArray(new String[set.size()]);
            Arrays.sort(words, new Comparator<String>() {
                @Override
                public int compare(String str1, String str2) {
                    int diff2 = str1.compareTo(str2);

                    return (Math.abs(diff2) == diff ? diff2 : str1.toLowerCase().compareTo(str2.toLowerCase()));
                }
            });

            for (String word : words) {
                sb.append(word).append("\n");
            }
        }

        System.out.write(sb.toString().getBytes());
    }

    private static HashSet<String> getPermutationSet(String line)
    {
        HashSet<String> set = new HashSet<>();

        permute(set, line.toCharArray(), 0, line.length() - 1);

        return set;
    }

    private static boolean permute(HashSet<String> set, char[] word, int start, int end)
    {
        if(start >= end)
        {
            return !set.add(new String(word));
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
        return true;
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
public class UVA195 {

    final static String packName = UVA195.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA195.class, chapter);
        Main195.main(args);
    }
}