package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main11530 {

    static HashMap<Character, Integer> keyMap = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        char[] sms;

        createKeyMap();

        int total;
        int k = 0;
        int testCases = Integer.parseInt(bf.readLine());
        while ((k++ < testCases) && (line = bf.readLine()) != null && !line.equals("0")) {
            sms = line.toCharArray();

            total = 0;

            for (int ii = 0; ii < sms.length; ii++) {
                total += keyMap.get(sms[ii]);
            }

            sb.append("Case #")
              .append(k)
              .append(": ")
              .append(total)
              .append("\n");
        }

        System.out.write(sb.toString().getBytes());
    }

    private static void createKeyMap()
    {
        keyMap.put('a', 1);
        keyMap.put('d', 1);
        keyMap.put('g', 1);
        keyMap.put('j', 1);
        keyMap.put('m', 1);
        keyMap.put('p', 1);
        keyMap.put('t', 1);
        keyMap.put('w', 1);
        keyMap.put(' ', 1);

        keyMap.put('b', 2);
        keyMap.put('e', 2);
        keyMap.put('h', 2);
        keyMap.put('k', 2);
        keyMap.put('n', 2);
        keyMap.put('q', 2);
        keyMap.put('u', 2);
        keyMap.put('x', 2);

        keyMap.put('c', 3);
        keyMap.put('f', 3);
        keyMap.put('i', 3);
        keyMap.put('l', 3);
        keyMap.put('o', 3);
        keyMap.put('r', 3);
        keyMap.put('v', 3);
        keyMap.put('y', 3);

        keyMap.put('s', 4);
        keyMap.put('z', 4);
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA11530 {

    final static String packName = UVA11530.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA11530.class, chapter);
        Main11530.main(args);
    }
}