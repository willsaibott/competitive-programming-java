package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main893 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String line;
        int daysToAdd;
        int day, month, year;
        GregorianCalendar calendar;


        while ((line = bf.readLine()) != null && !line.equals("0 0 0 0")) {
            st = new StringTokenizer(line);
            daysToAdd = Integer.parseInt(st.nextToken());
            day   = Integer.parseInt(st.nextToken());
            month = Integer.parseInt(st.nextToken());
            year  = Integer.parseInt(st.nextToken());
            calendar = new GregorianCalendar(year, month - 1, day);
            calendar.add(GregorianCalendar.DAY_OF_MONTH, daysToAdd);

            sb.append(calendar.get(GregorianCalendar.DATE))
              .append(" ")
              .append(calendar.get(GregorianCalendar.MONTH) + 1)
              .append(" ")
              .append(calendar.get(GregorianCalendar.YEAR))
              .append("\n");
        }

        System.out.write(sb.toString().getBytes());
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA893 {

    final static String packName = UVA893.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA893.class, chapter);
        Main893.main(args);
    }
}