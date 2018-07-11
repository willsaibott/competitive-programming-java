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
class Main11221 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String line;
        boolean begin = true;

        int k = 0;
        int testCases = Integer.parseInt(bf.readLine());
        while ((k++ < testCases) && (line = bf.readLine()) != null && !line.equals("0")) {
            char[][] input = parseInput(line);

            sb.append("Case #").append(k).append(":\n");

            if (input != null && isMagic(input))
            {
                sb.append(input.length).append("\n");
            }
            else
            {
                sb.append("No magic :(\n");
            }
        }

        System.out.write(sb.toString().getBytes());
    }

    public static char[][] parseInput(String line)
    {
        String cleaned = line.replaceAll("(\\s|\\.|\\?|,|!|\\(|\\))", "");
        double dLength = Math.pow(cleaned.length(), 0.5);
        int length = (int) dLength;
        if (length != (int) Math.ceil(dLength)) return null;

        char[][] result = new char[length][length];
        int ii = 0, jj = 0;



        for (char c : cleaned.toCharArray()) {
            result[ii][jj] = c;
            jj++;

            if (jj >= length)
            {
                jj = 0;
                ii++;
            }
        }

        return result;
    }

    public static boolean isMagic(char[][] input)
    {
        int length = input.length;

        for (int ii = 0; ii < length; ii++)
        {
            if (!isMagic(input, ii))
            {
                return false;
            }
        }
        return length == 0 || input[length-1][length-1] == input[0][0];
    }

    private static boolean isMagic(char[][] input, int pos)
    {
        for (int ii = pos + 1; ii < input.length; ii++)
        {
            if (input[ii][pos] != input[pos][ii])
            {
                return false;
            }
        }

        return true;
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA11221 {

    final static String packName = UVA11221.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA11221.class, chapter);
        Main11221.main(args);
    }
}