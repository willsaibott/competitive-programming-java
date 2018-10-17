package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimzations balanced the most I can.
 */
class Main10284 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;

        while ((line = bf.readLine()) != null) {
            String[] board = line.split("/");
            Chess chess = new Chess(board);

            System.out.println(chess.getFreePositions());
        }
    }

    static class AttackedPositions extends HashSet<Point>
    {
        @Override
        public boolean add(Point point) {
            boolean valid = (point.x >= 0 && point.x < 8 && point.y >= 0 && point.y < 8);

            if (valid) super.add(point);
            return valid;
        }
    }

    static class Chess
    {
        private AttackedPositions attackedPositions = new AttackedPositions();
        private AttackedPositions piecesPositions = new AttackedPositions();

        Chess(String[] board)
        {

            for (int ii = 0; ii < 8; ii++) {
                char[] pieces = board[ii].toCharArray();
                int y = 0;
                for (int jj = 0; jj < pieces.length; jj++, y++)
                {
                    if (Character.isDigit(pieces[jj]))
                    {
                        y += pieces[jj] - '1';
                    }
                    else
                    {
                        piecesPositions.add(new Point(ii, y));
                    }
                }
            }

            for (int ii = 0; ii < 8; ii++) {
                char[] pieces = board[ii].toCharArray();
                int y = 0;
                for (int jj = 0; jj < pieces.length; jj++, y++)
                {
                    if (!Character.isDigit(pieces[jj]))
                    {
                        checkAttackPositions(pieces[jj], new Point(ii, y));
                    }
                    else
                    {
                        y += pieces[jj] - '1';
                    }
                }
            }
        }

        int getFreePositions()
        {
            attackedPositions.addAll(piecesPositions);
            return 64  - attackedPositions.size();
        }

        void checkAttackPositions(char piece, Point point)
        {
            switch ((piece))
            {
                case 'p':
                    attackedPositions.add(new Point(point.x + 1, point.y + 1));
                    attackedPositions.add(new Point(point.x + 1, point.y - 1));
                    break;
                case 'P':
                    attackedPositions.add(new Point(point.x - 1, point.y + 1));
                    attackedPositions.add(new Point(point.x - 1, point.y - 1));
                    break;
                case 'q':
                case 'Q':
                    for (int x = point.x - 1, y = point.y - 1; !piecesPositions.contains(new Point(x, y)) && attackedPositions.add(new Point(x, y)); x--, y--);

                    for (int x = point.x - 1, y = point.y + 1; !piecesPositions.contains(new Point(x, y)) && attackedPositions.add(new Point(x, y)); x--, y++);

                    for (int x = point.x + 1, y = point.y - 1; !piecesPositions.contains(new Point(x, y)) && attackedPositions.add(new Point(x, y)); x++, y--);

                    for (int x = point.x + 1, y = point.y + 1; !piecesPositions.contains(new Point(x, y)) && attackedPositions.add(new Point(x, y)); x++, y++);

                case 'r':
                case 'R':
                    for (int x = point.x + 1, y = point.y; !piecesPositions.contains(new Point(x, y)); x++)
                        if (!attackedPositions.add(new Point(x, y))) break;
                    for (int x = point.x - 1, y = point.y; !piecesPositions.contains(new Point(x, y)); x--)
                        if (!attackedPositions.add(new Point(x, y))) break;
                    for (int y = point.y + 1, x = point.x; !piecesPositions.contains(new Point(x, y)); y++)
                        if (!attackedPositions.add(new Point(x, y))) break;
                    for (int y = point.y - 1, x = point.x; !piecesPositions.contains(new Point(x, y)); y--)
                        if (!attackedPositions.add(new Point(x, y))) break;
                    break;
                case 'b':
                case 'B':
                    for (int x = point.x - 1, y = point.y - 1; !piecesPositions.contains(new Point(x, y)); x--, y--)
                        if (!attackedPositions.add(new Point(x, y))) break;
                    for (int x = point.x - 1, y = point.y + 1; !piecesPositions.contains(new Point(x, y)); x--, y++)
                        if (!attackedPositions.add(new Point(x, y))) break;
                    for (int x = point.x + 1, y = point.y - 1; !piecesPositions.contains(new Point(x, y)); x++, y--)
                        if (!attackedPositions.add(new Point(x, y))) break;
                    for (int x = point.x + 1, y = point.y + 1; !piecesPositions.contains(new Point(x, y)); x++, y++)
                        if (!attackedPositions.add(new Point(x, y))) break;
                    break;
                case 'k':
                case 'K':
                    attackedPositions.add(new Point(point.x + 1, point.y + 1));
                    attackedPositions.add(new Point(point.x + 1, point.y - 1));
                    attackedPositions.add(new Point(point.x + 1, point.y    ));
                    attackedPositions.add(new Point(point.x    , point.y - 1));
                    attackedPositions.add(new Point(point.x    , point.y + 1));
                    attackedPositions.add(new Point(point.x - 1, point.y + 1));
                    attackedPositions.add(new Point(point.x - 1, point.y - 1));
                    attackedPositions.add(new Point(point.x - 1, point.y    ));
                    break;
                case 'n':
                case 'N':
                    attackedPositions.add(new Point(point.x + 2, point.y + 1));
                    attackedPositions.add(new Point(point.x + 2, point.y - 1));
                    attackedPositions.add(new Point(point.x - 2, point.y + 1));
                    attackedPositions.add(new Point(point.x - 2, point.y - 1));
                    attackedPositions.add(new Point(point.x + 1, point.y + 2));
                    attackedPositions.add(new Point(point.x + 1, point.y - 2));
                    attackedPositions.add(new Point(point.x - 1, point.y + 2));
                    attackedPositions.add(new Point(point.x - 1, point.y - 2));
                    break;
                default: break;
            }
        }
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA10284 {

    final static String packName = UVA10284.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA10284.class, chapter);
        Main10284.main(args);
    }
}