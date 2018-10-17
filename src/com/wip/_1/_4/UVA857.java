package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main857 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String line;
        HashMap<Integer, Message> performance = new HashMap<>();
        ArrayList<Message> outputList = new ArrayList<>();
        Message message, temp;
        int note, on, measure, beat, tick;

        while ((line = bf.readLine()) != null && !line.equals("-1")) {
            int total = Integer.parseInt(line);

            for (int ii = 0; ii < total; ii++)
            {
                line = bf.readLine();
                st = new StringTokenizer(line);

                on      = Integer.parseInt(st.nextToken());
                note    = Integer.parseInt(st.nextToken());
                measure = Integer.parseInt(st.nextToken());
                beat    = Integer.parseInt(st.nextToken());
                tick    = Integer.parseInt(st.nextToken());

                outputList.add(new Message(note, measure, beat, tick, on));
            }

            for (int ii = 0; ii < outputList.size(); ii++)
            {
                if ((message = outputList.get(ii)).getOn() == 0) continue;

                for (int jj = ii + 1; jj < outputList.size(); jj++)
                {
                    temp = outputList.get(jj);
                    if (message.getNote() == temp.getNote() && temp.getOn() == 0)
                    {
                        if (message.equals(temp)) {
                            outputList.remove(jj);
                            outputList.remove(ii);
                            ii--;
                        }
                        break;
                    }
                }
            }

            sb.append(outputList.size()).append("\n");

            for (Message msg : outputList) {
                sb.append(msg.getOn())
                  .append(" ")
                  .append(msg.getNote())
                  .append(" ")
                  .append(msg.getMeasure())
                  .append(" ")
                  .append(msg.getBeat())
                  .append(" ")
                  .append(msg.getTick())
                  .append("\n");
            }

            performance.clear();
            outputList.clear();
        }

        System.out.write(sb.append("-1\n").toString().getBytes());
    }

    static class Message {
        private int note;
        private int measure;
        private int beat;
        private int tick;
        private int on;

        public Message(int note, int measure, int beat, int tick, int on) {
            this.measure = measure;
            this.beat = beat;
            this.tick = tick;
            this.note = note;
            this.on = on;
            quantise();
        }

        public int[] quantise() {
            tick = ((tick + 30) / 60) * 60;

            if (tick >= 480) {
                tick = 0;
                beat++;

                if (beat > 4) {
                    beat = 1;
                    measure++;
                }
            }
            return new int[]{measure, beat, tick};
        }

        public boolean equals(Message msg2) {
            return (msg2.getMeasure() == this.measure &&
                    msg2.getBeat() == this.beat &&
                    msg2.getTick() == this.tick);
        }

        public int getMeasure() {
            return measure;
        }

        public int getBeat() {
            return beat;
        }

        public int getTick() {
            return tick;
        }

        public int getNote() {
            return note;
        }

        public int getOn() {
            return on;
        }
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA857 {

    final static String packName = UVA857.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA857.class, chapter);
        Main857.main(args);
    }
}