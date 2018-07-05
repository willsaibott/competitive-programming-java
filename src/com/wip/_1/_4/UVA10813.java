package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main10813 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int[] limits = {16, 31, 46, 61, 76};

        int k = 0;
        int testCases = Integer.parseInt(bf.readLine());
        while (k++ < testCases) {
            HashMap<Integer, Point> bingo = new HashMap<>();
            int cards = 0;
            int gameOverAt = 0;
            int spaceCol = -1;
            int offset = 0;

            for (int ii = 0; ii < 5; ii++) {
                st =  new StringTokenizer(bf.readLine());

                for (int jj = 0; st.hasMoreTokens(); jj++) {
                    int n = Integer.parseInt(st.nextToken());

                    if (ii == 2)
                    {
                        if (spaceCol == -1 && n >= limits[jj])
                        {
                            spaceCol = jj;
                            offset = 1;
                        }

                        bingo.put(n, new Point(ii, jj + offset));
                    }
                    else
                    {
                        bingo.put(n, new Point(ii, jj));
                    }

                }
            }

            if (spaceCol == -1) spaceCol = 4;
            Point p;
            int[][] board = new int[5][5];
            boolean usedSpace = false;

            while (cards++ < 75)
            {
                if (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(bf.readLine());

                int card = Integer.parseInt(st.nextToken());

                if ((p = bingo.remove(card)) != null)
                {
                    board[p.x][p.y] = 1;
                } else if (!usedSpace &&
                           (card < limits[spaceCol]) &&
                           (spaceCol == 0 || card >= limits[spaceCol - 1]))
                {
                    board[2][spaceCol] = 1;
                    usedSpace = true;
                }

                if (gameOverAt == 0 && isGameOver(board))
                {
                    gameOverAt = cards;
                }
            }

            System.out.println("BINGO after " + gameOverAt + " numbers announced");
        }
    }

    private static boolean isGameOver(int[][] board)
    {
        int ii, jj;
        for (ii = 0; ii < 5; ii++) {
            jj = 0;
            while (board[ii][jj++] == 1)
            {
                if (jj == 5) return true;
            }
        }

        for (jj = 0; jj < 5; jj++) {
            ii = 0;
            while (board[ii++][jj] == 1)
            {
                if (ii == 5) return true;
            }
        }

        ii = jj = 0;
        while (board[ii++][jj++] == 1)
        {
            if (ii == 5) return true;
        }

        ii = 4;
        jj = 0;
        while (board[ii--][jj++] == 1)
        {
            if (jj == 5) return true;
        }

        return false;
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA10813 {

    final static String packName = UVA10813.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA10813.class, chapter);
        Main10813.main(args);
    }
}