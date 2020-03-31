package com.wip._2._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static com.wip.Utils.defineInputMethod;


/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA12504 {

    final static String packName = UVA12504.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA12504.class, chapter);
        Main12504.main(args);
    }
}


/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main12504 {

    private static class Solution {

        Map<String, String>  dictionary[] = new Map[]{ new TreeMap<>(), new TreeMap<>() };

        public void add_to(int dict_index, String key, String value) {
            if (!value.isEmpty() && !key.isEmpty()) {
                dictionary[dict_index].put(key, value);
            }
        }

        private void add_words(List<String> list, StringBuilder sb) {
            boolean first = true;
            for (String word: list) {
                if (first) {
                    first = false;
                    sb.append(word);
                }
                else {
                    sb.append(",").append(word);
                }
            }
        }


        public void solve(StringBuilder sb) {
            int max_size = Math.max(dictionary[0].size(), dictionary[1].size());
            List<String> added_words   = new ArrayList<>(max_size);
            List<String> removed_words = new ArrayList<>(max_size);
            List<String> changed_words = new ArrayList<>(max_size);

            for (Map.Entry<String, String> entry : dictionary[0].entrySet()) {
                String other = dictionary[1].get(entry.getKey());
                if (other != null) {
                    if (!entry.getValue().equals(other)) {
                        changed_words.add(entry.getKey());
                    }
                }
                else {
                    removed_words.add(entry.getKey());
                }
            }

            for (Map.Entry<String, String> entry : dictionary[1].entrySet()) {
                String other = dictionary[0].get(entry.getKey());
                if (other == null) {
                    added_words.add(entry.getKey());
                }
            }

            if (added_words.isEmpty() && removed_words.isEmpty() && changed_words.isEmpty()) {
                sb.append("No changes\n\n");
            } else {
                if (!added_words.isEmpty()) {
                    sb.append("+");
                    add_words(added_words, sb);
                    sb.append("\n");
                }
                if (!removed_words.isEmpty()) {
                    sb.append("-");
                    add_words(removed_words, sb);
                    sb.append("\n");
                }
                if (!changed_words.isEmpty()) {
                    sb.append("*");
                    add_words(changed_words, sb);
                    sb.append("\n");
                }
                sb.append("\n");
            }
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String regex = "\\s|,|:|\\{|\\}";

        int k = 0;
        int testCases = Integer.parseInt(bf.readLine());
        while (k++ < testCases) {
            Solution solution = new Solution();
            String words[] = bf.readLine().split(regex);
            for (int ii = 1; ii < words.length-1; ii+=2) {
                solution.add_to(0, words[ii], words[ii+1]);
            }
            String words_new[] = bf.readLine().split(regex);
            for (int ii = 1; ii < words_new.length-1; ii+=2) {
                solution.add_to(1, words_new[ii], words_new[ii+1]);
            }

            solution.solve(sb);
        }

        System.out.write(sb.toString().getBytes());
    }
}
