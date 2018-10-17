package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main232 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;
        int k = 1;
        boolean begin = true;

        while ((line = bf.readLine()) != null && !line.equals("0")) {
            int rows, columns;
            char[][] crossword;
            int[][] indexes;
            int index = 0;
            StringBuilder outBuffer = new StringBuilder();
            LinkedHashMap<Integer, String> across = new LinkedHashMap<>();
            LinkedHashMap<Integer, String> down = new LinkedHashMap<>();
            st = new StringTokenizer(line);

            rows      = Integer.parseInt(st.nextToken());
            columns   = Integer.parseInt(st.nextToken());
            crossword = new char[rows][];
            indexes = new int[rows][columns];

            for (int ii = 0; ii < rows; ii++) {
                crossword[ii] = bf.readLine().toCharArray();

                for (int jj = 0; jj < columns; jj++) {

                    if (crossword[ii][jj] != '*' &&
                        (ii == 0 ||
                         jj == 0 ||
                         crossword[ii][jj - 1] == '*' ||
                         crossword[ii - 1][jj] == '*'))
                    {
                        indexes[ii][jj] = ++index;
                    }
                }
            }

            for (int ii = 0; ii < rows; ii++)
            {
                for (int jj = 0; jj < columns; jj++)
                {
                    if (indexes[ii][jj] > 0)
                    {
                        int zz = 0;
                        String word = "";

                        if (jj == 0 || crossword[ii][jj - 1] == '*')
                        {

                            while (jj + zz < columns && crossword[ii][jj + zz] != '*')
                            {
                                word += crossword[ii][jj + zz++];
                            }

                            across.put(indexes[ii][jj], word);
                        }

                        zz   = 0;
                        word = "";

                        if (ii == 0 || crossword[ii - 1][jj] == '*')
                        {
                            while (ii + zz < rows && crossword[ii + zz][jj] != '*')
                            {
                                word += crossword[ii + zz++][jj];
                            }

                            down.put(indexes[ii][jj], word);
                        }
                    }
                }
            }

            if (!begin) outBuffer.append("\n");
            begin = false;

            outBuffer.append("puzzle #").append(k++).append(":\nAcross\n");

            for (Entry<Integer, String> entry : across.entrySet())
            {
                if (entry.getKey() > 9)
                {
                    outBuffer.append(" ");
                }
                else
                {
                    outBuffer.append("  ");
                }

                outBuffer.append(entry.getKey()).append(".").append(entry.getValue()).append("\n");
            }

            outBuffer.append("Down\n");
            for (Entry<Integer, String> entry : down.entrySet()) {
                if (entry.getKey() > 9)
                {
                    outBuffer.append(" ");
                }
                else
                {
                    outBuffer.append("  ");
                }

                outBuffer.append(entry.getKey()).append(".").append(entry.getValue()).append("\n");
            }

            System.out.write(outBuffer.toString().getBytes());
        }
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA232 {

    final static String packName = UVA232.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA232.class, chapter);
        Main232.main(args);
    }
}