package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main227 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;
        String invalid = "This puzzle has no final configuration.";
        boolean begin = true;
        boolean isInvalid;
        boolean isOver = false;

        int k = 1;
        while (true) {
            char[][] board = new char[5][];
            Point space = null;
            isOver = false;
            isInvalid = false;

            for (int ii = 0; ii < 5; ii++) {
                board[ii] = bf.readLine().toCharArray();

                if (board[ii].length == 1 && board[ii][0] == 'Z') return;
                if (board[ii].length < 5)
                {
                    char[] newboard = new char[5];
                    newboard[0] = board[ii][0];
                    newboard[1] = board[ii][1];
                    newboard[2] = board[ii][2];
                    newboard[3] = board[ii][3];
                    newboard[4] = ' ';
                    board[ii] = newboard;
                    space = new Point(ii, 4);
                }

                if (space == null)
                {
                    for (int jj = 0; jj < board[ii].length; jj++) {
                        if (board[ii][jj] == ' ')
                        {
                            space = new Point(ii, jj);
                        }
                    }
                }
            }

            if (space == null)
            {
                throw new RuntimeException("No Space found: ");
            }

            if (!begin) System.out.println();
            begin = false;

            while(!isOver)
            {
                char[] moves = bf.readLine().toCharArray();

                for (char move : moves) {
                    Point newSpace = null;
                    switch (move)
                    {
                        case 'A':
                            newSpace = new Point(space.x - 1, space.y);
                            break;
                        case 'B':
                            newSpace = new Point(space.x + 1, space.y);
                            break;
                        case 'R':
                            newSpace = new Point(space.x, space.y + 1);
                            break;
                        case 'L':
                            newSpace = new Point(space.x, space.y - 1);
                            break;
                        case '0':
                            String output = "Puzzle #" + k++ + ":" ;
                            if (!isInvalid)
                            {
                                for (char[] row : board) {
                                    output +=  "\n";
                                    for (int jj = 0; jj < row.length - 1; jj++) {
                                        output += row[jj] + " ";
                                    }
                                    output += row[row.length - 1];
                                }
                                System.out.println(output);
                            }
                            else
                            {
                                System.out.println(output);
                                System.out.println(invalid);
                            }
                            isOver = true;
                            break ;
                        default:
                            isInvalid = true;
                            break;
                    }

                    if (!isOver)
                    {
                        isInvalid = isInvalid || newSpace.x < 0 || newSpace.x >= 5 || newSpace.y < 0 || newSpace.y >= 5;

                        if (!isInvalid)
                        {
                            board[space.x][space.y]       = board[newSpace.x][newSpace.y];
                            board[newSpace.x][newSpace.y] = ' ';
                            space = newSpace;
                        }
                    }
                }
            }
        }
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA227 {

    final static String packName = UVA227.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA227.class, chapter);
        Main227.main(args);
    }
}