package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main145 {

    static double[][] chargesMap =
            { { 0.10, 0.06, 0.02 },
              { 0.25, 0.15, 0.05 },
              { 0.53, 0.33, 0.13 },
              { 0.87, 0.47, 0.17 },
              { 1.44, 0.80, 0.30 } };
    static Interval[] intervals =
            {
              new Interval(0, 0, 8, 0),
              new Interval(8, 0, 18, 0),
              new Interval(18, 0, 22, 0),
              new Interval(22, 0, 32, 0),
              new Interval(32, 0, 42, 0),
              new Interval(42, 0, 46, 0),
              new Interval(46, 0, 48, 0),
            };

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String line, phone;
        char step;
        double[] charges;
        Interval call;
        int[] spentTime;

        while ((line = bf.readLine()) != null && !line.equals("#"))
        {
            st = new StringTokenizer(line);
            step = st.nextToken().charAt(0);
            charges = chargesMap[step - 'A'];
            phone   = st.nextToken();

            call = new Interval(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
            );

            spentTime = call.getSpentTime();

            sb.append(
                String.format(
                    "%1$10s%2$6d%3$6d%4$6d%5$3s%6$8.2f\n",
                    phone,
                    spentTime[0],
                    spentTime[1],
                    spentTime[2],
                    step,
                    call.getCost(charges)
                )
            );
        }

        System.out.write(sb.toString().getBytes());
    }

    static class Interval
    {
        private Time start, end;
        private int[] spentTime = { 0, 0, 0};
        private int mins;

        public Interval(int h1, int m1, int h2, int m2)
        {
            start = new Time(h1, m1);
            end   = new Time(h2 + ( (h1 > h2 || (h1 == h2 && m1 >= m2) ) ? 24 : 0), m2);
            mins = end.compareTo(start);
        }

        public Time getStart() {
            return start;
        }

        public Time getEnd() {
            return end;
        }

        public int[] getSpentTime()
        {
            int diff;
            for (int ii = 0; ii < intervals.length; ii++)
            {
                diff = includesInterval(intervals[ii]) ?
                       Math.max(
                           0,
                           min(intervals[ii].getMins(),
                               intervals[ii].end.compareTo(start),
                               end.compareTo(intervals[ii].start),
                               mins)) :
                       0;

                spentTime[(ii + 2) % 3] += diff;
            }
            return spentTime;
        }

        private boolean includesInterval(Interval interval) {
            return !((start.compareTo(interval.end) > 0) ||
                     (end.compareTo(interval.start) < 0));
        }

        public double getCost(double[] charges)
        {
            double sum = 0;

            for (int ii = 0; ii < charges.length; ii++) {
                sum +=  charges[ii] * spentTime[ii];
            }
            return sum;
        }

        public int getMins() {
            return mins;
        }

        public int min (int... values)
        {
            int min = Integer.MAX_VALUE;
            for (int value : values) {
                if (min > value)
                {
                    min = value;
                }
            }

            return min;
        }
    }

    static class Time implements Comparable<Time>
    {
        int hour;
        int min;

        public Time(int hour, int min) {
            this.hour = hour;
            this.min = min;
        }

        @Override
        public int compareTo(Time time) {
            return (this.hour - time.hour) * 60 + (this.min - time.min);
        }
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA145 {

    final static String packName = UVA145.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA145.class, chapter);
        Main145.main(args);
    }
}