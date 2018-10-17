package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main379 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        String line;

        int k = 0;
        int testCases = Integer.parseInt(bf.readLine());
        System.out.println("HI Q OUTPUT");


        while (k++ < testCases)
        {
            ArrayList<Integer> pegs = new ArrayList<>();
            Board board;

            do
            {
                if (st == null || !st.hasMoreTokens())
                {
                    st = new StringTokenizer(bf.readLine());
                }

                int peg = Integer.parseInt(st.nextToken());

                if (peg > 0)
                {
                    pegs.add(peg);
                }
                else
                {
                    board = new Board(pegs);
                    board.move();
                    break;
                }
            }
            while (true);

            System.out.println(board.getSum());
        }

        System.out.println("END OF OUTPUT");;
    }

    static class Board
    {
        private int[][] board;
        private ArrayList<Integer> pegs;
        private int sum = 0;
        private int[] map;

        Board(ArrayList<Integer> pegs)
        {
            int row, column, pos;
            this.board = generateBoard();
            this.map   = getMap();

            for (Integer peg : pegs)
            {
                pos    = map[peg];
                row    = pos / 7;
                column = pos % 7;
                board[row][column] = -board[row][column];
            }
        }

        private static int[][] generateBoard() {
            return new int[][] {{ 0, 0, 1, 2, 3, 0, 0 },
                                { 0, 0, 4, 5, 6, 0, 0 },
                                { 7, 8, 9,10,11,12,13 },
                                {14,15,16,17,18,19,20 },
                                {21,22,23,24,25,26,27 },
                                { 0, 0,28,29,30, 0, 0 },
                                { 0, 0,31,32,33, 0, 0 }};
        }

        private static int[] getMap()
        {
            return new int[] { 0, 2, 3, 4, 9,10,11,
                              14,15,16,17,18,19,20,
                              21,22,23,24,25,26,27,
                              28,29,30,31,32,33,34,
                              37,38,39,44,45,46};
        }

        public int getSum() {
            return sum;
        }

        public void move()
        {
            Point origin = new Point(0, 0);
            Point move;
            int source, target, row0, row1, col0, col1;

            while (!(move = getMovement()).equals(origin))
            {
                source = map[Math.abs(move.x)];
                target = map[Math.abs(move.y)];
                row0 = source / 7;
                col0 = source % 7;
                row1 = target / 7;
                col1 = target % 7;
                board[row0][col0] = -board[row0][col0];
                board[row1][col1] = -board[row1][col1];
                board[(row0 + row1) / 2][(col0 + col1) / 2] = -board[(row0 + row1) / 2][(col0 + col1) / 2];
            }

            sum = 0;
            for (int[] boardRow : board) {
                for (int hole : boardRow) {
                    if (hole < 0)
                    {
                        sum -= hole;
                    }
                }
            }
        }

        public Point getMovement()
        {
            Point move = new Point(0, 0);

            for (int ii = 0; ii < board.length; ii++) {
                for (int jj = 0; jj < board[0].length; jj++) {

                    if (ii > 1 && board[ii][jj] < 0 && board[ii - 1][jj] < 0 && board[ii - 2][jj] > 0)
                    {
                        move = max(move, new Point(board[ii][jj], board[ii-2][jj]));
                    }

                    if (ii < board.length - 2 && board[ii][jj] < 0 && board[ii + 1][jj] < 0 && board[ii + 2][jj] > 0)
                    {
                        move = max(move, new Point(board[ii][jj], board[ii+2][jj]));
                    }

                    if (jj > 1 && board[ii][jj] < 0 && board[ii][jj - 1] < 0 && board[ii][jj - 2] > 0)
                    {
                        move = max(move, new Point(board[ii][jj], board[ii][jj-2]));
                    }

                    if (jj < board.length - 2 && board[ii][jj] < 0 && board[ii][jj+1] < 0 && board[ii][jj+2] > 0)
                    {
                        move = max(move, new Point(board[ii][jj], board[ii][jj+2]));
                    }
                }
            }

            return move;
        }

        private Point max(Point p1, Point p2)
        {
            int diff1 = Math.abs(p1.x) - Math.abs(p2.x);
            int diff2 = Math.abs(p1.y) - Math.abs(p2.y);

            return ((diff2 != 0) ?
                    (diff2 > 0 ? p1 : p2) :
                    (diff1 > 0 ? p1 : p2));
        }
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA379 {

    final static String packName = UVA379.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA379.class, chapter);
        Main379.main(args);
    }
}