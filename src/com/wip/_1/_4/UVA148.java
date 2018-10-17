package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main148 {

    public static HashSet<String> invalidWords = new HashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        ArrayList<Word> dictionary = new ArrayList<Word>();

        while ((line = bf.readLine()) != null && !line.equals("#"))
        {
            dictionary.add(new Word(line));
        }

        while ((line = bf.readLine()) != null && !line.equals("#"))
        {
            String[] words = line.split(" ");

            invalidWords.clear();
            for (String word : words) {
                invalidWords.add(word);
            }

            ArrayList<String> sets = getSets(dictionary, new Sentence(line));

            for (String set : sets) {
                sb.append(line)
                  .append(" = ")
                  .append(set)
                  .append("\n");
            }
        }

        System.out.write(sb.toString().getBytes());
    }

    private static ArrayList<String> getSets(ArrayList<Word> dictionary, Sentence sentence)
    {
        ArrayList<String> sets = new ArrayList<>();
        int size = dictionary.size();

        for (int ii = 0; ii < size; ii++)
        {
            findAnagramSet(dictionary,
                           ii,
                           sentence,
                           "",
                           sets);
        }

        return sets;
    }

    private static void findAnagramSet(ArrayList<Word> dictionary,
                                       int position,
                                       Sentence sentence,
                                       String path,
                                       ArrayList<String> sets)
    {
        Word word = dictionary.get(position);
        int[] wFreq = word.getLettersFrequency();
        int[] sFreq = sentence.getLettersFrequency();
        boolean match = true;
        int size = dictionary.size();

        if(invalidWords.contains(word.toString())) return;

        for (int ii = 0; ii <  26; ii++)
        {
            sFreq[ii] -= wFreq[ii];

            if (sFreq[ii] < 0)
            {
                return;
            }
            if (sFreq[ii] > 0)
            {
                match = false;
            }
        }

        if (match)
        {
            path += word.toString();
            sets.add(path);
        }
        else if (position + 1 < dictionary.size())
        {
            String childPath = path + word.toString() + " ";
            for (int ii = position + 1; ii < size; ii++) {
                    findAnagramSet(dictionary,
                                   ii,
                                   new Sentence(sFreq, sentence.toString()),
                                   childPath,
                                   sets);
            }
        }
    }

    static class Sentence extends Word
    {
        public Sentence(String string) {
            super(string);
        }

        public Sentence(int[] lettersFrequency, String string) {
            super("");
            this.string = string;
            this.lettersFrequency = lettersFrequency;
        }

        @Override
        public int[] getLettersFrequency() {
            int[] copy = Arrays.copyOf(lettersFrequency, 26);
            return copy;
        }
    }

    static class Word
    {
        protected int[] lettersFrequency;
        protected String string;

        public Word(String string) {
            this.string = string;
            this.lettersFrequency = new int[26];

            for (char c : string.toCharArray()) {
                if (c != ' ')
                {
                    lettersFrequency[c - 'A']++;
                }
            }
        }

        public String toString()
        {
            return string;
        }

        public int[] getLettersFrequency() {
            return lettersFrequency;
        }
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA148 {

    final static String packName = UVA148.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA148.class, chapter);
        Main148.main(args);
    }
}