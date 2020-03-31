package com.wip._2._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static com.wip.Utils.defineInputMethod;


/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA11860 {

    final static String packName = UVA11860.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA11860.class, chapter);
        Main11860.main(args);
    }
}


/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main11860 {

    private static class Sequence implements Comparable<Sequence> {
        public final int start;
        public final int end;

        public Sequence(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public Sequence(Sequence other) {
            this(other.start, other.end);
        }

        public final int difference() {
            return end - start;
        }

        @Override
        public int compareTo(Sequence other) {
            int diff = difference() - other.difference() ;
            return diff != 0 ? diff : start - other.start;
        }

        @Override
        public String toString() {
            return "Sequence{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    private static class Solution {
        Set<String>             words             = new HashSet<>(100000);
        List<String>            words_in_sequence = new ArrayList<>(100000);

        public void add(String words[]) {
            for (String word : words) {
                if (!word.isEmpty()) {
                    this.words_in_sequence.add(word);
                    this.words.add(word);
                }
            }
        }

        public void add(String word) {
            if (!word.isEmpty()) {
                this.words_in_sequence.add(word);
                this.words.add(word);
            }
        }

        public void solve(StringBuilder sb) {
            Map<String, Integer> words_of_sequence = words.size() > 50 ? new HashMap<>(words.size()) : new TreeMap<>();
            TreeSet<Integer> subset = new TreeSet<>();
            int begin = 0, current = 0, target = words.size();
            Sequence best = null;

            for (int ii = 0; ii < words_in_sequence.size(); ii++) {
                String word = words_in_sequence.get(ii);
                int index = words_of_sequence.getOrDefault(word, -1);
                if (index >= 0) {
                    subset.remove(index);
                }
                words_of_sequence.put(word, ii);
                subset.add(ii);
                current = words_of_sequence.size();

                if (current == target) {
                    Sequence next = new Sequence(subset.first(), ii);
                    if (best == null || best.compareTo(next) > 0) {
                        best = next;
                    }
                }
            }

            if (best != null) {
                sb.append(best.start+1).append(" ").append(best.end+1).append("\n");
            }
            else {
                sb.append("1 0\n");
            }
        }

        public void clear() {
            words.clear();
            words_in_sequence.clear();
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb  = new StringBuilder();
        String line;
        int testCases = Integer.parseInt(bf.readLine());
        int k = 0;

        while (k++ < testCases) {
            Solution solution = new Solution();
            while (!(line = bf.readLine()).equals("END")) {
                StringBuilder wordBuilder = new StringBuilder();
                for (int ii = 0; ii < line.length(); ii++) {
                    char c = line.charAt(ii);
                    if (c >= 'a' && c <= 'z') {
                        wordBuilder.append(c);
                    }
                    else if (wordBuilder.length() > 0) {
                        solution.add(wordBuilder.toString());
                        wordBuilder = new StringBuilder();
                    }
                }
                if (wordBuilder.length() > 0) {
                    solution.add(wordBuilder.toString());
                }

            }
            solution.solve(sb.append("Document ").append(k).append(": "));
        }

        System.out.write(sb.toString().getBytes());
    }
}
