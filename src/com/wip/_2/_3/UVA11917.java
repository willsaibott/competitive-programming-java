package com.wip._2._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static com.wip.Utils.defineInputMethod;


/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA11917 {

    final static String packName = UVA11917.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA11917.class, chapter);
        Main11917.main(args);
    }
}


/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main11917 {

    private static  class Subject {
        public final String name;
        public final int    days;

        public Subject(String name, int days) {
            this.name = name;
            this.days = days;
        }
    }

    private static class Solution {

        Map<String, Subject>   subjects;

        public Solution(int amount) {
            subjects = amount > 50 ? new HashMap<>() : new TreeMap<>();
        }

        public void add(Subject subject) {
            subjects.put(subject.name, subject);
        }

        public void solve(StringBuilder sb, Subject requested) {
            Subject object = subjects.get(requested.name);
            if (object != null) {
                if (requested.days >= object.days) {
                    sb.append("Yesss\n");
                }
                else if (requested.days + 5 >= object.days) {
                    sb.append("Late\n");
                }
                else {
                    sb.append("Do your own homework!\n");
                }
            }
            else {
                sb.append("Do your own homework!\n");
            }
        }
    }



    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCases = Integer.parseInt(bf.readLine());
        int subjects;
        int k = 0;
        while (k++ < testCases) {
            subjects = Integer.parseInt(bf.readLine());
            Solution solution = new Solution(subjects);

            for (int ii = 0; ii < subjects; ii++) {
                String words[] = bf.readLine().split("\\s");
                solution.add( new Subject(words[0], Integer.parseInt(words[1])) );
            }

            int days       = Integer.parseInt(bf.readLine());
            String subject = bf.readLine();

            solution.solve(sb.append("Case ").append(k).append(": "),  new Subject(subject, days));
        }

        System.out.write(sb.toString().getBytes());
    }
}
