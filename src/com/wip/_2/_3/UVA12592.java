package com.wip._2._3;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA12592 {

    final static String packName = UVA12592.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA12592.class, chapter);
        Main12592.main(args);
    }
}


/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main12592 {

    private static class Slogan {
        final public String first;
        final public String second;

        public Slogan(String first, String second) {
            this.first = first;
            this.second = second;
        }
    }

    private static class Solution {

        Map<String, Slogan>  slogans         = new TreeMap<>();
        List<String>         first_part_said = new ArrayList<>(100);

        public void add(Slogan slogan) {
            slogans.put(slogan.first, slogan);
        }

        public void say(String first, StringBuilder sb) {
            Slogan slogan = slogans.get(first);
            if (slogan != null) {
                sb.append(slogan.second);
            }
            sb.append("\n");
        }

        public void clear() {
            slogans.clear();
            first_part_said.clear();
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Solution solution = new Solution();

        int slogans = Integer.parseInt(bf.readLine());
        for (int ii = 0; ii < slogans; ii++) {
            solution.add(new Slogan(bf.readLine(), bf.readLine()));
        }

        int said = Integer.parseInt(bf.readLine());
        for (int ii = 0; ii < said; ii++) {
            solution.say(bf.readLine(), sb);
        }

        System.out.write(sb.toString().getBytes());
    }
}
