package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main401 {

    public final static String NONE = "is not a palindrome.";
    public final static String PALINDROME = "is a regular palindrome.";
    public final static String MIRRORED = "is a mirrored string.";
    public final static String MIRRORED_PALINDROME = "is a mirrored palindrome.";
    static HashMap<Character, Character> reverseMap = new HashMap<>();


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        boolean begin = true;


        reverseMap.put('A', 'A');
        reverseMap.put('E', '3');
        reverseMap.put('H', 'H');
        reverseMap.put('I', 'I');
        reverseMap.put('J', 'L');
        reverseMap.put('L', 'J');
        reverseMap.put('M', 'M');
        reverseMap.put('O', 'O');
        reverseMap.put('S', '2');
        reverseMap.put('T', 'T');
        reverseMap.put('U', 'U');
        reverseMap.put('V', 'V');
        reverseMap.put('W', 'W');
        reverseMap.put('X', 'X');
        reverseMap.put('Y', 'Y');
        reverseMap.put('Z', '5');
        reverseMap.put('1', '1');
        reverseMap.put('2', 'S');
        reverseMap.put('3', 'E');
        reverseMap.put('5', 'Z');
        reverseMap.put('8', '8');


        while ((line = bf.readLine()) != null) {

            if (!begin) sb.append("\n");
            begin = false;

            sb.append(line).append(" -- ");

            WordClass wordClass = getWordClass(line);

            switch (wordClass)
            {
                case none:
                    sb.append(NONE);
                    break;
                case mirrored:
                    sb.append(MIRRORED);
                    break;
                case palindrome:
                    sb.append(PALINDROME);
                    break;
                case mirroredPalindrome:
                    sb.append(MIRRORED_PALINDROME);
                    break;
            }

            sb.append("\n");
        }

        System.out.write(sb.append("\n").toString().getBytes());
    }

    private static WordClass getWordClass(String line)
    {
        WordClass wordClass = WordClass.none;
        Validation validation = validate(line);

        if (validation.isMirrored() && validation.isPalindrome())
        {
            wordClass = WordClass.mirroredPalindrome;
        }
        else if (validation.isMirrored())
        {
            wordClass = WordClass.mirrored;
        }
        else if (validation.isPalindrome())
        {
            wordClass = WordClass.palindrome;
        }
        return wordClass;
    }

    private static Validation validate(String word)
    {
        int length = word.length();
        char[] sub, comp;
        boolean isPalindrome = true;
        boolean isMirrored = true;

        sub = comp = word.toCharArray();

        for (int ii = 0; ii < length; ii++)
        {
            if (comp[ii] != sub[length - (ii + 1)])
            {
                isPalindrome = false;
            }

            Character reverse = reverseMap.get(sub[length - (ii + 1)]);
            if (reverse == null || comp[ii] != reverse.charValue())
            {
                isMirrored = false;
            }
        }

        return new Validation(isPalindrome, isMirrored);
    }

    enum WordClass
    {
        none,
        palindrome,
        mirrored,
        mirroredPalindrome
    }

    static class Validation
    {
        private boolean palindrome;
        private boolean mirrored;

        public Validation(boolean palindrome, boolean mirrored) {
            this.palindrome = palindrome;
            this.mirrored = mirrored;
        }

        public boolean isPalindrome() {
            return palindrome;
        }

        public boolean isMirrored() {
            return mirrored;
        }

    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA401 {

    final static String packName = UVA401.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA401.class, chapter);
        Main401.main(args);
    }
}