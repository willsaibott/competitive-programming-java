package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main403 {

    static String[][] c5map =
            {{" ***  ", "****  ", " **** ", "****  ", "***** ", "***** ", " **** ", "*   * ", "***** ", "  *** ", "*   * ", "*     ", "*   * ", "*   * ", " ***  ", "****  ", " ***  ", "****  ", " **** ", "***** ", "*   * ", "*   * ", "*   * ", "*   * ", "*   * ", "***** ", "      "},
             {"*   * ", "*   * ", "*   * ", "*   * ", "*     ", "*     ", "*     ", "*   * ", "  *   ", "   *  ", "*  *  ", "*     ", "** ** ", "**  * ", "*   * ", "*   * ", "*   * ", "*   * ", "*     ", "* * * ", "*   * ", "*   * ", "*   * ", " * *  ", " * *  ", "   *  ", "      "},
             {"***** ", "****  ", "*     ", "*   * ", "***   ", "***   ", "*  ** ", "***** ", "  *   ", "   *  ", "***   ", "*     ", "* * * ", "* * * ", "*   * ", "****  ", "*   * ", "****  ", " ***  ", "  *   ", "*   * ", " * *  ", "* * * ", "  *   ", "  *   ", "  *   ", "      "},
             {"*   * ", "*   * ", "*     ", "*   * ", "*     ", "*     ", "*   * ", "*   * ", "  *   ", "*  *  ", "*  *  ", "*     ", "*   * ", "*  ** ", "*   * ", "*     ", "*  ** ", "*  *  ", "    * ", "  *   ", "*   * ", " * *  ", "** ** ", " * *  ", "  *   ", " *    ", "      "},
             {"*   * ", "****  ", " **** ", "****  ", "***** ", "*     ", " ***  ", "*   * ", "***** ", " **   ", "*   * ", "***** ", "*   * ", "*   * ", " ***  ", "*     ", " **** ", "*   * ", "****  ", " ***  ", " ***  ", "  *   ", "*   * ", "*   * ", "  *   ", "***** ", "      "}};

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String line;
        char[][] page = generateEmptyPage();
        int row, col;
        String font, text;

        while ((line = bf.readLine()) != null) {

            st = new StringTokenizer(line);

            switch (st.nextToken())
            {
                case ".P":
                    font = st.nextToken();
                    row = Integer.parseInt(st.nextToken()) - 1;
                    col = Integer.parseInt(st.nextToken()) - 1;
                    text = line.substring(line.indexOf("|"));
                    print(page, row, col, convertFont(font, text));
                    break;
                case ".L":
                    font = st.nextToken();
                    row = Integer.parseInt(st.nextToken()) - 1;
                    text = line.substring(line.indexOf("|"));
                    printLeft(page, row, convertFont(font, text));
                    break;
                case ".R":
                    font = st.nextToken();
                    row = Integer.parseInt(st.nextToken()) - 1;
                    text = line.substring(line.indexOf("|"));
                    printRight(page, row, convertFont(font, text));
                    break;
                case ".C":
                    font = st.nextToken();
                    row = Integer.parseInt(st.nextToken()) - 1;
                    text = line.substring(line.indexOf("|"));
                    printCenter(page, row, convertFont(font, text), font);
                    break;
                case ".EOP":
                    for (int ii = 0; ii < 60; ii++) {
                        sb.append(page[ii]).append("\n");
                    }
                    sb.append("\n------------------------------------------------------------\n\n");
                    page = generateEmptyPage();
                    break;
            }
        }

        System.out.write(sb.toString().getBytes());
    }

    static char[][] generateEmptyPage()
    {
        char[][] page = new char[60][60];

        for (int ii = 0; ii < 60; ii++) {
            Arrays.fill(page[ii], '.');
        }
        return page;
    }

    static void print(char[][] page, int row, int col, char[][] printable)
    {
        char c;
        int lim2 = (printable[0].length + col);
        int lim1 = (printable.length + row);
        int offset = 0;

        if (col < 0)
        {
            offset = -col;
            col = 0;
        }

        for (int ii = row; ii < lim1 && ii < 60; ii++)
        {
            for (int jj = col; jj < lim2 && jj < 60; jj++) {
                c = printable[ii - row][jj - col + offset];

                if (c != ' ') page[ii][jj] = c;
            }
        }
    }

    static void printLeft(char[][] page, int row, char[][] printable)
    {
        print(page, row, 0, printable);
    }

    static void printRight(char[][] page, int row, char[][] printable)
    {
        char c;
        int lim2 = (printable[0].length);
        int lim1 = (printable.length + row);

        for (int ii = row; ii < lim1 && ii < 60; ii++)
        {
            for (int jj = 0; jj < lim2 && jj < 60; jj++) {
                c = printable[ii - row][lim2 - jj - 1];

                if (c != ' ') page[ii][59 - jj] = c;
            }
        }
    }

    static void printCenter(char[][] page, int row, char[][] printable, String font)
    {
        int col;
        int length0 = printable[0].length;

        if(font.equals("C5"))
        {
            col = 30 - length0 / 2 ;//- ((length0 / 6) & 1) * 6;
        }
        else
        {
            col = 30 - length0 / 2;// - (length0 & 1);
        }

        print(page, row, col, printable);
    }

    static char[][] convertFont(String font, String text)
    {
        text = text.substring(1, text.length() - 1);
        if (font.equals("C1"))
        {
            return  new char[][] { text.toCharArray() };
        }
        else
        {
            return convertC5(text.toCharArray());
        }
    }

    static char[][] convertC5(char[] text)
    {
        int length = text.length, index = 0;
        char[][] c5 = new char[5][length * 6];

        for (int ii = 0; ii < length; ii++) {
            switch (text[ii])
            {
                case ' ':
                case '.':
                case '*':
                    index = 26;
                    break;
                default:
                    index = text[ii] - 'A';
                    break;
            }

            for (int jj = 0; jj < 5; jj++) {
                char[] array = c5map[jj][index].toCharArray();

                for (int kk = 0; kk < 6; kk++) {
                    c5[jj][ii * 6 + kk] = array[kk];
                }
            }
        }

        return c5;
    }

}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA403 {

    final static String packName = UVA403.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA403.class, chapter);
        Main403.main(args);
    }
}