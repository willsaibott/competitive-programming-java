package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main346 {

    static HashMap<String, Integer> map = new HashMap<>();
    static String[] chromatic = { "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#" };

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String line;
        Chord chord;

        createMap();

        while ((line = bf.readLine()) != null) {
            line = line.trim();
            st = new StringTokenizer(line);
            sb.append(line).append(" is ");

            chord =
                new Chord(
                    new String[]
                    {
                        st.nextToken().toUpperCase(),
                        st.nextToken().toUpperCase(),
                        st.nextToken().toUpperCase()
                    });

            if (chord.isMajor())
            {
                sb.append("a ")
                  .append(chord.getName())
                  .append(" Major chord.\n");

            } else if (chord.isMinor())
            {
                sb.append("a ")
                  .append(chord.getName())
                  .append(" Minor chord.\n");

            } else
            {
                sb.append("unrecognized.\n");
            }
        }

        System.out.write(sb.toString().getBytes());
    }

    private static void createMap() {

        map.put("AB", 11);
        map.put("A",  0);
        map.put("A#", 1);
        map.put("BB", 1);
        map.put("B",  2);
        map.put("B#", 3);
        map.put("CB", 2);
        map.put("C",  3);
        map.put("C#", 4);
        map.put("DB", 4);
        map.put("D",  5);
        map.put("D#", 6);
        map.put("EB", 6);
        map.put("E",  7);
        map.put("E#", 8);
        map.put("FB", 7);
        map.put("F",  8);
        map.put("F#", 9);
        map.put("GB", 9);
        map.put("G",  10);
        map.put("G#", 11);
    }

    static class Chord
    {
        int[] notes;
        boolean major = false;
        boolean minor = false;
        String name = null;

        public Chord(String[] notes) {
            this.notes = convert(notes);

            check();
        }

        private void check() {
            for (int ii = 0; ii < 3; ii++) {

                if ((notes[(ii + 1) % 3] == (notes[ii] + 4) % 12) &&
                    (notes[(ii + 2) % 3] == (notes[ii] + 7) % 12))
                {
                    major = true;
                    name = chromatic[notes[ii]];
                    break;
                }
                else if ((notes[(ii + 1) % 3] == (notes[ii] + 3) % 12) &&
                         (notes[(ii + 2) % 3] == (notes[ii] + 7) % 12))
                {
                    minor = true;
                    name = chromatic[notes[ii]];
                    break;
                }
            }
        }

        private int[] convert(String[] notes) {
            int[] array = new int[] { map.get(notes[0]),
                                      map.get(notes[1]),
                                      map.get(notes[2])};

            Arrays.sort(array);
            return array;
        }

        public boolean isMajor() {
            return major;
        }

        public boolean isMinor() {
            return minor;
        }

        public String getName() {
            return name;
        }
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA346 {

    final static String packName = UVA346.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA346.class, chapter);
        Main346.main(args);
    }
}