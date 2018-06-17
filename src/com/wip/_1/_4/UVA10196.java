package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimzations balanced the most I can.
 */
class Main10196 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line;

        int k = 0;
        while (true)
        {
            String output = "king is in check.";
            String[] board = new String[9];
            Chess chess;
            int row = 0;

            while ((line = bf.readLine()) != null && !line.equals(""))
            {
                board[row++] = line;
            }

            chess = new Chess(board);

            if (chess.isGameOver()) break;

            if (chess.isInCheck())
            {
                output = ((chess.winner == 1) ? "white " : "black ") + output;
            }
            else
            {
                output = "no " + output;
            }

            System.out.println("Game #" + ++k + ": " + output);
        }
    }


    static class Chess
    {
        King white, black;
        char[][] board = new char[8][8];
        int winner = 0;
        int count = 0;

        Chess(String[] board)
        {
            for(int ii = 0; ii < 8; ii++)
            {
                this.board[ii] = board[ii].toCharArray();

                for (int jj = 0; jj < 8; jj++)
                {
                    char piece = this.board[ii][jj];
                    if (piece == 'k')
                    {
                        count++;
                        white = new King('k', ii, jj);
                    } else if (piece == 'K')
                    {
                        count++;
                        black = new King('K', ii, jj);
                    }
                }
            }
        }

        boolean isInCheck()
        {
            for (int ii = 0; ii < 8; ii++)
            {
                for (int jj = 0; jj < 8; jj++)
                {
                    if (isAnyPieceAttackingKing(board[ii][jj], new Point(ii, jj)))
                    {
                        return true;
                    }
                }
            }
            return false;
        }

        boolean isAnyPieceAttackingKing(char piece, Point point)
        {
            int ii = point.x;
            int jj = point.y;

            boolean attacking = false;

            switch (piece)
            {
                case 'p':
                    attacking = ((new Point(ii + 1, jj + 1).equals(black)) ||
                                 (new Point(ii + 1, jj - 1).equals(black)));
                    winner = (attacking) ? 1: 0;
                    break;
                case 'P':
                    attacking = ((new Point(ii - 1, jj + 1).equals(white)) ||
                                 (new Point(ii - 1, jj - 1).equals(white)));
                    winner = (attacking) ? 2: 0;
                    break;
                case 'r':
                    attacking = isAttackingByRow(point, black) ||
                                isAttackingByColumn(point, black);
                    winner = (attacking) ? 1: 0;
                    break;
                case 'R':
                    attacking =  isAttackingByRow(point, white) ||
                                 isAttackingByColumn(point, white);
                    winner = (attacking) ? 2: 0;
                    break;
                case 'b':
                    attacking = isAttackingKing(point, black, false);
                    winner = (attacking) ? 1: 0;
                    break;
                case 'B':
                    attacking = isAttackingKing(point, white, false);
                    winner = (attacking) ? 2: 0;
                    break;
                case 'q':
                    attacking = isAttackingByRow(point, black) ||
                                isAttackingByColumn(point, black) ||
                                isAttackingKing(point, black, false);
                    winner = (attacking) ? 1: 0;
                    break;
                case 'Q':
                    attacking = isAttackingByRow(point, white) ||
                                isAttackingByColumn(point, white) ||
                                isAttackingKing(point, white, false);
                    winner = (attacking) ? 2: 0;
                    break;
                case 'k':
                    attacking = isAttackingKing(point, black, true);
                    winner = (attacking) ? 1: 0;
                    break;
                case 'K':
                    attacking = isAttackingKing(point, white, true);
                    winner = (attacking) ? 2: 0;
                    break;
                case 'n':
                    attacking = isAttackingKnight(point, black);
                    winner = (attacking) ? 1: 0;
                    break;
                case 'N':
                    attacking = isAttackingKnight(point, white);
                    winner = (attacking) ? 2: 0;
                    break;
                default: break;
            }

            return attacking;
        }

        boolean isGameOver()
        {
            return count < 2;
        }

        boolean isAttackingByRow(Point point, King king)
        {
            boolean attacking = point.y == king.y;
            int diff = Math.abs(point.x - king.x);
            if (diff == 0) return false;
            int it = (king.x - point.x) / diff;

            if (attacking)
            {
                for (int x = point.x + it; x != king.x && x < 8 && x >= 0; x += it )
                {
                    if (board[x][point.y] != '.' && !(new Point(x, point.y).equals(king)))
                    {
                        attacking = false;
                        break;
                    }
                }

            }

            return attacking;
        }

        boolean isAttackingByColumn(Point point, King king)
        {
            boolean attacking = point.x == king.x;
            int diff = Math.abs(point.y - king.y);
            if (diff == 0) return false;
            int it = (king.y - point.y) / diff;

            if (attacking)
            {
                for (int y = point.y + it; y != king.y && y < 8 && y >= 0; y += it )
                {
                    if (board[point.x][y] != '.' && !(new Point(point.x, y).equals(king)))
                    {
                        attacking = false;
                        break;
                    }
                }

            }

            return attacking;
        }

        boolean isAttackingKing(Point piece, King king, boolean isKing)
        {
            boolean attacking = false;

            if (isKing)
            {
                int x = piece.x;
                int y = piece.y;

                attacking = new Point(x - 1, y - 1).equals(king) ||
                            new Point(x - 1, y + 1).equals(king) ||
                            new Point(x + 1, y - 1).equals(king) ||
                            new Point(x + 1, y + 1).equals(king) ||
                            new Point(x - 1, y    ).equals(king) ||
                            new Point(x + 1, y    ).equals(king) ||
                            new Point(x    , y - 1).equals(king) ||
                            new Point(x    , y + 1).equals(king);
            }
            else
            {
                int x = piece.x;
                int y = piece.y;
                while (!attacking && (--x >= 0 && --y >= 0)) {
                    if (board[x][y] != '.' && !(attacking = new Point(x, y).equals(king))) break;
                }

                x = piece.x;
                y = piece.y;
                while (!attacking && (--x >= 0 && ++y <= 7))
                {
                    if (board[x][y] != '.' && !(attacking = new Point(x, y).equals(king))) break;
                }

                x = piece.x;
                y = piece.y;
                while (!attacking && (++x <= 7 && --y >= 0)) {
                    if (board[x][y] != '.' && !(attacking = new Point(x, y).equals(king))) break;
                }

                x = piece.x;
                y = piece.y;
                while (!attacking && (++x <= 7 && ++y <= 7)) {
                    if (board[x][y] != '.' && !(attacking = new Point(x, y).equals(king))) break;
                }
            }
            return attacking;
        }

        boolean isAttackingKnight(Point point, Point king)
        {
            return (new Point(point.x + 2, point.y + 1).equals(king)) ||
                   (new Point(point.x + 2, point.y - 1).equals(king)) ||
                   (new Point(point.x - 2, point.y + 1).equals(king)) ||
                   (new Point(point.x - 2, point.y - 1).equals(king)) ||
                   (new Point(point.x + 1, point.y + 2).equals(king)) ||
                   (new Point(point.x + 1, point.y - 2).equals(king)) ||
                   (new Point(point.x - 1, point.y + 2).equals(king)) ||
                   (new Point(point.x - 1, point.y - 2).equals(king));
        }
    }

    static class King extends Point
    {
        char king;

        King (char king, int x, int y)
        {
            super(x, y);
            this.king = king;
        }
    }
}


/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA10196 {

    final static String packName = UVA10196.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA10196.class, chapter);
        Main10196.main(args);
    }
}