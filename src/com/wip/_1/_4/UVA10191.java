package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main10191 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String line;

        List<Appointment> appointments = new ArrayList<>();
        List<Appointment> naps = new LinkedList<>();

        int k = 0;
        while ((line = bf.readLine()) != null)
        {
            int n = Integer.parseInt(line);
            Appointment max = null, current;

            naps.add(new Appointment(new Time("10:00"), new Time("18:00")));

            for (int ii = 0; ii < n; ii++) {
                st = new StringTokenizer(bf.readLine());

                current = new Appointment(
                                new Time(st.nextToken()),
                                new Time(st.nextToken()));
                appointments.add(current);

                for (int jj = 0; jj < naps.size(); jj++) {
                    Appointment next = naps.get(jj);

                    if (next.start.compare(current.start) < 0)
                    {
                        if (next.end.compare(current.end) > 0)
                        {
                            naps.add(new Appointment(current.end, next.end));
                        }

                        if (next.end.compare(current.start) > 0)
                        {
                            next.end = new Time(current.start);
                        }
                    }
                    else
                    {
                        if (current.end.compare(next.start) > 0)
                        {
                            next.start = new Time(current.end);
                        }
                    }
                }
            }

            int diff, maxDiff = -1;
            Iterator<Appointment> iterator = naps.iterator();

            while (iterator.hasNext())
            {
                Appointment next = iterator.next();

                diff = next.diff();

                if (diff > maxDiff ||
                    (diff == maxDiff && next.start.compare(max.start) < 0))
                {
                    max = next;
                    maxDiff = diff;
                }
            }

            sb.append("Day #")
                    .append(++k)
                    .append(": the longest nap starts at ")
                    .append(max.start.toString())
                    .append(" and will last for ");

            if (maxDiff >= 60)
            {
                sb.append(maxDiff / 60).append(" hours and ");
            }

            sb.append(maxDiff % 60).append(" minutes.\n");
            naps.clear();

            appointments.clear();
        }

        System.out.write(sb.toString().getBytes());
    }


    static class Time
    {
        int hour;
        int min;

        public Time(String time) {
            hour = Integer.parseInt(time.substring(0, 2));
            min = Integer.parseInt(time.substring(3));
        }

        public Time(Time time) {
            this.hour = time.hour;
            this.min = time.min;
        }

        int compare(Time time)
        {
            return (this.hour - time.hour) * 60 + this.min - time.min;
        }

        public String toString()
        {
            return hour + String.format(":%02d", min);
        }
    }

    static class Appointment
    {
        Time start;
        Time end;
        String name;

        public Appointment(Time start, Time end) {
            this.start = new Time(start);
            this.end = new Time(end);
            this.name = start.toString();
        }

        int diff()
        {
            return end.compare(start);
        }
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA10191 {

    final static String packName = UVA10191.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA10191.class, chapter);
        Main10191.main(args);
    }
}
