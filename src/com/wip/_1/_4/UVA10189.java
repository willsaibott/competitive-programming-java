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
class Main10189 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;
        boolean begin = true;

        int k = 0;
        while ((line = bf.readLine()) != null && !line.equals("0 0"))
        {
            int m, n;
            char[][] field;
            st = new StringTokenizer(line);
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            field = new char[m][];

            if (!begin) System.out.println();

            begin = false;

            for (int ii = 0; ii < m; ii++)
            {
                field[ii] = bf.readLine().toCharArray();
            }

            System.out.println("Field #" + ++k + ":");

            for (int ii = 0; ii < m; ii++)
            {
                for (int jj = 0; jj < n; jj++)
                {
                    if (field[ii][jj] == '.')
                        field[ii][jj] = getBombCount(field, ii, jj);
                }
                System.out.println(field[ii]);
            }
        }
    }

    static char getBombCount(char[][] field, int row, int column)
    {
        int row_min = Math.max(0, row - 1);
        int column_min = Math.max(0, column - 1);
        int row_max = Math.min(field.length - 1, row + 1);
        int column_max = Math.min(field[0].length - 1, column + 1);
        int bombs = 0;

        for (int ii = row_min; ii <= row_max; ii++)
        {
            for (int jj = column_min; jj <= column_max; jj++)
            {
                if (ii == row && jj == column) continue;

                if (field[ii][jj] == '*') bombs++;
            }
        }

        return (char)('0' + bombs);
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA10189 {

    final static String packName = UVA10189.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA10189.class, chapter);
        Main10189.main(args);
    }
}