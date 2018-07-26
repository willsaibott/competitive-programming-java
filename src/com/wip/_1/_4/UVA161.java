package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main161 {

    public static int MAX_TIME = 3600 * 5;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        String line;
        boolean running = true;
        boolean allGreen = false;
        int period;
        ArrayList<TrafficLight> trafficLights = new ArrayList<>();


        while (running) {
            int ii;
            int minPeriod = Integer.MAX_VALUE;

            do {
                if (st == null || !st.hasMoreTokens())
                {
                    do {
                        line = bf.readLine();
                    } while (line.equals(""));

                    if (line.equals("0 0 0"))
                    {
                        running = false;
                        break;
                    }

                    st = new StringTokenizer(line);
                }
                period = Integer.parseInt(st.nextToken());

                if (period > 0)
                {
                    minPeriod = Math.min(minPeriod, period);
                    trafficLights.add(new TrafficLight(period));
                }

            } while (period != 0);

            if (!running) break;

            allGreen = false;
            for (ii = 2 * minPeriod; ii <= MAX_TIME && !allGreen; ii++) {
                allGreen = true;

                for (TrafficLight trafficLight : trafficLights)
                {
                    if (!trafficLight.getStateAt(ii).equals(TrafficState.green))
                    {
                        allGreen = false;
                        break;
                    }
                }
            }

            if (allGreen)
            {
                int time = ii - 1;
                int hour = (time / 3600);
                int min = (time % 3600) / 60;
                int seconds =  (time % 60);
                sb.append(String.format("%02d:%02d:%02d", hour, min, seconds))
                  .append("\n");
            }
            else
            {
                sb.append("Signals fail to synchronise in 5 hours\n");
            }

            trafficLights.clear();
        }


        System.out.write(sb.toString().getBytes());
    }

    enum TrafficState {
        green, yellow, red
    }

    static class TrafficLight
    {
        private int period = 10;
        private TrafficState state = TrafficState.green;

        public TrafficLight(int period)
        {
            this.period = period;
        }

        public TrafficState getStateAt(int time)
        {
            return ((((time / period) & 1) == 1) ?
                    TrafficState.red :
                    (((time % period) < (period - 5)) ?
                     TrafficState.green :
                     TrafficState.yellow));
        }
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA161 {

    final static String packName = UVA161.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA161.class, chapter);
        Main161.main(args);
    }
}