package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main10528 {

    static int[] majorScale = { 2, 2, 1, 2, 2, 2, 1 };
    static String[] notes = { "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#" };
    static HashMap<String, HashSet<String>> scales = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        List<String> possibleScales;
        boolean begin;

        while ((line = bf.readLine()) != null && !line.equals("END"))
        {
            possibleScales = getPossibleList(line.split(" "));
            begin = true;

            for (String possibleScale : possibleScales) {
                if (!begin) sb.append(" ");
                begin = false;

                sb.append(possibleScale);
            }
            sb.append("\n");
        }

        System.out.write(sb.toString().getBytes());
    }

    public static HashSet<String> createScale(String note)
    {
        HashSet<String> scale = new HashSet<>();
        int index = Arrays.binarySearch(notes, note);

        scale.add(note);

        for (int ii : majorScale) {
            index = (index + ii) % notes.length;
            scale.add(notes[index]);
        }

        return scale;
    }

    public static ArrayList<String> getPossibleList(String[] inputs)
    {
        ArrayList<String> list = new ArrayList<>();
        HashSet<String> scale;
        boolean possible;
        String note;

        for (int ii = 0; ii < notes.length; ii++)
        {
            possible = true;
            note = notes[(ii + 3) % notes.length];
            for (String input : inputs)
            {
                if ((scale = scales.get(note)) == null)
                {
                    scale = createScale(note);
                    scales.put(note, scale);
                }

                if (!(possible = scale.contains(input))) break;
            }

            if(possible)
            {
                list.add(note);
            }
        }
        return list;
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA10528 {

    final static String packName = UVA10528.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA10528.class, chapter);
        Main10528.main(args);
    }
}