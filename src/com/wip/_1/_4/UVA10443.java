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
class Main10443 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        String line;
        boolean begin = true;

        int k = 0;
        int testCases = Integer.parseInt(bf.readLine());
        while (k++ < testCases && (line = bf.readLine()) != null) {
            int rows, columns, days;
            char[][] board;

            st = new StringTokenizer(line);
            rows    = Integer.parseInt(st.nextToken());
            columns = Integer.parseInt(st.nextToken());
            days    = Integer.parseInt(st.nextToken());

            if (!begin) sb.append("\n");
            begin = false;

            if (rows > 0 && columns > 0)
            {
                board = new char[rows][];

                for (int ii = 0; ii < rows; ii++)
                {
                    board[ii] = bf.readLine().toCharArray();
                }

                RockScissorsPaper rockScissorsPaper = new RockScissorsPaper(board);
                char[][] newBoard = rockScissorsPaper.simulate(days).getBoard();

                for (int ii = 0; ii < rows; ii++)
                {
                    sb.append(newBoard[ii]).append("\n");
                }
            }
            else
            {
                bf.readLine();
            }
        }

        System.out.write(sb.toString().getBytes());
    }


    static class RockScissorsPaper
    {
        private char[][] board;

        public RockScissorsPaper(char[][] board) {
            this.board = board;
        }


        public char[][] getBoard() {
            return board;
        }

        public RockScissorsPaper simulate(int days)
        {
            int rows = board.length;
            int columns = board[0].length;
            char[][] newBoard = new char[rows][columns];
            char[][] nextBoard;

            copy(board, newBoard);

            for (int zz = 0; zz < days; zz++)
            {
                nextBoard = new char[rows][columns];
                for (int ii = 0; ii < rows; ii++)
                {
                    for (int jj = 0; jj < columns; jj++)
                    {
                        char newValue;
                        if (ii > 0 && ((newValue = evaluate(newBoard[ii-1][jj], newBoard[ii][jj])) != newBoard[ii][jj]))
                        {
                            nextBoard[ii][jj] = newValue;
                        } else if (ii < rows - 1 && ((newValue = evaluate(newBoard[ii+1][jj], newBoard[ii][jj])) != newBoard[ii][jj]))
                        {
                            nextBoard[ii][jj] = newValue;
                        } else if (jj > 0 && ((newValue = evaluate(newBoard[ii][jj-1], newBoard[ii][jj])) != newBoard[ii][jj]))
                        {
                            nextBoard[ii][jj] = newValue;
                        } else if (jj < columns - 1 && ((newValue = evaluate(newBoard[ii][jj+1], newBoard[ii][jj])) != newBoard[ii][jj]))
                        {
                            nextBoard[ii][jj] = newValue;
                        } else
                        {
                            nextBoard[ii][jj] = newBoard[ii][jj];
                        }
                    }
                }
                newBoard = nextBoard;
            }

            return new RockScissorsPaper(newBoard);
        }

        public char evaluate(char ch1, char ch2)
        {
            char result;
            if ((ch1 == 'R' && ch2 == 'S') ||
                (ch1 == 'S' && ch2 == 'P') ||
                (ch1 == 'P' && ch2 == 'R'))
            {
                result = ch1;
            } else
            {
                result = ch2;
            }
            return result;
        }

        public void copy(char[][] array1, char[][] array2)
        {
            for (int ii = 0; ii < array1.length; ii++) {
                for (int jj = 0; jj < array1[0].length; jj++) {
                    array2[ii][jj] = array1[ii][jj];
                }
            }
        }
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA10443 {

    final static String packName = UVA10443.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA10443.class, chapter);
        Main10443.main(args);
    }
}