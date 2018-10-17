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
class Main10363 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;

        int k = 0;
        int testCases = Integer.parseInt(bf.readLine());
        while (k++ < testCases)
        {
            char[][] board = new char[3][];
            int xs = 0, os = 0;
            String output;

            for (int ii = 0; ii < 3; ii++) {
                board[ii] = bf.readLine().toCharArray();

                for (int jj = 0; jj < 3; jj++)
                {
                    if (board[ii][jj] == 'X') xs++;
                    if (board[ii][jj] == 'O') os++;
                }
            }
            bf.readLine();

            int diff = xs - os;
            Match match;

            if (k == 402)
            {
                int a = 0;
            }
            if (diff < 0 ||
                diff > 1 ||
                (match = check(board)).hasDoubleMatch() ||
                (match.getMatch() == 'O' && diff != 0) ||
                (match.getMatch() == 'X' && diff != 1))
            {
                output = "no";
            }
            else
            {
                output = "yes";
            }

            System.out.println(output);
        }
    }

    private static Match check(char[][] board)
    {
        char value;
        char matches = '.';
        for (int ii = 0; ii < 3; ii++)
        {
            value = board[ii][0];
            if (board[ii][1] == value && board[ii][2] == value)
            {
                if (matches == '.')
                {
                    matches = value;
                }
                else if (value != '.')
                {
                    return new Match(value, true);
                }
            }
        }

        for (int jj = 0; jj < 3; jj++)
        {
            value = board[0][jj];
            if (board[1][jj] == value && board[2][jj] == value)
            {
                if (matches == '.')
                {
                    matches = value;
                }
                else if (matches != value && value != '.')
                {
                    return new Match(value, true);
                }
            }
        }

        value = board[0][0];
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2])
        {
            if (matches == '.')
            {
                matches = value;
            }
            else if (matches != value && value != '.')
            {
                return new Match(value, true);
            }
        }

        value = board[0][2];
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0])
        {
            if (value != '.')
            {
                matches = value;
                if (matches != '.' && matches != value)
                {
                    return new Match(value, true);
                }
            }
        }

        return new Match(matches, false);
    }

    static class Match
    {
        private char match = '.';
        private boolean doubleMatch = false;

        public Match(char match, boolean doubleMatch) {
            this.match = match;
            this.doubleMatch = doubleMatch;
        }

        public char getMatch() {
            return match;
        }

        public boolean hasDoubleMatch() {
            return doubleMatch;
        }
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA10363 {

    final static String packName = UVA10363.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA10363.class, chapter);
        Main10363.main(args);
    }
}