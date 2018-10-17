package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main139 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        String line;
        Map<String, Destination> map = new HashMap<>();
        Destination destination = null;
        Destination local = new Destination("Local", 0.0);
        Destination unknown = new Destination("Unknown", -1.0);
        String name, code, fullPhone, phone = "", format = "%1$-16s%2$-25s%3$10s%4$5d%5$6s%6$7s\n";
        int duration, index, length;

        while ((line = bf.readLine()) != null && !line.equals("000000"))
        {
            index = line.indexOf(" ");
            code = line.substring(0, index);
            name = line.substring(index + 1);
            index = name.indexOf("$");

            map.put(
                code,
                new Destination(
                    name.substring(0, index),
                    Double.parseDouble(name.substring(index + 1))));
        }

        while ((line = bf.readLine()) != null && !line.equals("#"))
        {

            if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(line);
            fullPhone = st.nextToken();
            if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(bf.readLine());
            duration = Integer.parseInt(st.nextToken());

            if (fullPhone.startsWith("0"))
            {
                index = 2;
                do
                {
                    code = fullPhone.length() > index ? fullPhone.substring(0, index) : "";
                    destination = map.get(code);

                    if (destination != null)
                    {
                        phone = fullPhone.substring(index);
                        length = phone.length();

                        if (length < 4 ||
                            length > 10 ||
                            (fullPhone.charAt(1) != '0' && length > 7))
                        {
                            destination = null;
                        }
                    }

                } while ((destination == null) && ++index <= 6);

                if (destination == null)
                {
                    destination = unknown;
                    phone = "";
                }
            }
            else
            {
                destination = local;
                phone = fullPhone;
            }

            sb.append(
                String.format(format,
                              fullPhone,
                              destination.getName(),
                              phone,
                              duration,
                              destination.getCost(),
                              destination.getCost(duration)));
        }

        System.out.write(sb.toString().getBytes());
    }

    static class Destination
    {
        private String name;
        private double cost;

        public Destination(String name, double cost) {
            this.name = name;
            this.cost = cost / 100.0;
        }

        public String getName() {
            return name;
        }

        public String getCost() {
            return (cost >= 0) ? String.format("%5.2f", cost) : "";
        }

        public String getCost(int duration) {
            return (cost >= 0) ? String.format("%6.2f", cost * duration) : "-1.00";
        }
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA139 {

    final static String packName = UVA139.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA139.class, chapter);
        Main139.main(args);
    }
}