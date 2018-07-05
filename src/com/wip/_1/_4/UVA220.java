package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main220 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;
        char[][] board = new char[8][];
        char player;

        int k = 0;
        String output;
        int testCases = Integer.parseInt(bf.readLine());

        while (k++ < testCases)
        {
            for (int ii = 0; ii < 8; ii++) {
                board[ii] = bf.readLine().toCharArray();
            }

            if (k > 1)
            {
                System.out.println();
            }

            player = bf.readLine().charAt(0);

            while((line = bf.readLine()) != null && !line.equals("Q"))
            {
                if (line.equals("L"))
                {
                    HashSet<Point> movements = getMovements(board, player);

                    if (movements.isEmpty())
                    {
                        System.out.println("No legal move.");
                        continue;
                    }
                    else
                    {
                        Point[] moves = movements.toArray(new Point[movements.size()]);

                        Arrays.sort(moves, new Comparator<Point>() {
                            @Override
                            public int compare(Point p1, Point p2) {
                                int diff1 = p1.x - p2.x;
                                int diff2 = p1.y - p2.y;
                                return (diff1 != 0 ? diff1 : diff2);
                            }
                        });

                        output = "";

                        for (Point move : moves) {
                            output += "(" + (move.x + 1) + "," + (move.y + 1) + ") ";
                        }

                        System.out.println(output.trim());
                    }

                }
                else
                {
                    int x = (line.charAt(1) - '0') - 1;
                    int y = (line.charAt(2) - '0') - 1;

                    ArrayList<Bracket> brackets = getBrackets(board, x, y, player);

                    if (x== 1 && y == 2)
                    {
                        int a = 0;
                    }

                    if (brackets.isEmpty())
                    {
                        player = swapPlayer(player);
                        brackets = getBrackets(board, x, y, player);
                    }

                    fill(board, brackets, player);

                    int[] counts = new int[2];

                    for (int ii = 0; ii < 8; ii++) {
                        for (int jj = 0; jj < 8; jj++) {
                            if (board[ii][jj] == 'W')
                            {
                                counts[1]++;
                            }
                            else if (board[ii][jj] == 'B')
                            {
                                counts[0]++;
                            }
                        }
                    }

                    player = swapPlayer(player);
                    System.out.printf("Black - %2d White - %2d\n", counts[0], counts[1]);
                }
            }
            for (char[] chars : board) {
                System.out.println(chars);
            }
        }
    }

    private static void fill(char[][] board, ArrayList<Bracket> brackets, char color)
    {
        for (Bracket bracket : brackets) {
            switch (bracket.getType())
            {
                case UP:
                    for (int xx = bracket.getStart().x; xx < bracket.getEnd().x; xx++) {
                        board[xx][bracket.getStart().y] = color;
                    }
                    break;
                case DOWN:
                    for (int xx = bracket.getStart().x; xx > bracket.getEnd().x; xx--) {
                        board[xx][bracket.getStart().y] = color;
                    }
                    break;
                case LEFT:
                    for (int yy = bracket.getStart().y; yy > bracket.getEnd().y; yy--) {
                        board[bracket.getStart().x][yy] = color;
                    }
                    break;
                case RIGHT:
                    for (int yy = bracket.getStart().y; yy < bracket.getEnd().y; yy++) {
                        board[bracket.getStart().x][yy] = color;
                    }
                    break;
                case UP_LEFT:
                    for (int yy = bracket.getStart().y, xx = bracket.getStart().x;
                         yy > bracket.getEnd().y && xx < bracket.getEnd().x;
                         yy--, xx++)
                    {
                        board[xx][yy] = color;
                    }
                    break;
                case UP_RIGHT:
                    for (int yy = bracket.getStart().y, xx = bracket.getStart().x;
                         yy < bracket.getEnd().y && xx < bracket.getEnd().x;
                         yy++, xx++)
                    {
                        board[xx][yy] = color;
                    }
                    break;
                case DOWN_LEFT:
                    for (int yy = bracket.getStart().y, xx = bracket.getStart().x;
                         yy > bracket.getEnd().y && xx > bracket.getEnd().x;
                         yy--, xx--)
                    {
                        board[xx][yy] = color;
                    }
                    break;
                case DOWN_RIGHT:
                    for (int yy = bracket.getStart().y, xx = bracket.getStart().x;
                         yy < bracket.getEnd().y && xx > bracket.getEnd().x;
                         yy++, xx--)
                    {
                        board[xx][yy] = color;
                    }
                    break;
            }

        }
    }

    public static char swapPlayer(char player)
    {
        return (player == 'W' ? 'B' : 'W');
    }

    public static HashSet<Point> getMovements(char[][] board, int row, int column, char color)
    {
        HashSet<Point> moves = new HashSet<>();
        ArrayList<Bracket> brackets = getBrackets(board, row, column, color);

        for (Bracket bracket : brackets) {
            moves.add(bracket.getEnd());
        }
        return moves;
    }

    public static HashSet<Point> getMovements(char[][] board, char color)
    {
        HashSet<Point> moves = new HashSet<>();
        ArrayList<Bracket> brackets = null;

        for (int ii = 0; ii < 8; ii++) {
            for (int jj = 0; jj < 8; jj++) {
                if (board[ii][jj] == '-')
                {
                    brackets = getBrackets(board, ii, jj, color);

                    for (Bracket bracket : brackets) {
                        moves.add(bracket.getStart());
                    }
                }
            }
        }
        return moves;
    }

    public static ArrayList<Bracket> getBrackets(char[][] board, int row, int column, char color)
    {
        ArrayList<Bracket> array = new ArrayList<>();
        Bracket bracket;

        if ((bracket = check(board, row, column, color, new int[] { 1, 0, 1, 0 }, BracketType.UP)) != null)
            array.add(bracket); // horizontal Right
        if ((bracket = check(board, row, column, color, new int[] { -1, 0, -1, 0 }, BracketType.DOWN)) != null)
            array.add(bracket); // horizontal Left

        if ((bracket = check(board, row, column, color, new int[] { 0, 1, 0, 1 }, BracketType.RIGHT)) != null)
            array.add(bracket); // Vertical up
        if ((bracket = check(board, row, column, color, new int[] { 0, -1, 0, -1 }, BracketType.LEFT)) != null)
            array.add(bracket); // vertical down

        if ((bracket = check(board, row, column, color, new int[] { 1, 1, 1, 1 }, BracketType.UP_RIGHT)) != null)
            array.add(bracket); // diagonal up-right
        if ((bracket = check(board, row, column, color, new int[] { 1, -1, 1, -1 }, BracketType.UP_LEFT)) != null)
            array.add(bracket); // diagonal down-right
        if ((bracket = check(board, row, column, color, new int[] { -1, 1, -1, 1 }, BracketType.DOWN_RIGHT)) != null)
            array.add(bracket); // diagonal up-left
        if ((bracket = check(board, row, column, color, new int[] { -1, -1, -1, -1 }, BracketType.DOWN_LEFT)) != null)
            array.add(bracket); // diagonal down-left

        return array;
    }

    public static Bracket check(char[][] board,
                                int row,
                                int column,
                                char color,
                                int[] params,
                                BracketType type)
    {
        Bracket bracket = null;
        boolean hasOther = false;
        int offsetX = params[0];
        int offsetY = params[1];
        int incrX = params[2];
        int incrY = params[3];

        for (int xx = row + offsetX, yy = column + offsetY;
             xx < 8 && xx >= 0 && yy >= 0 && yy < 8;
             xx += incrX, yy += incrY)
        {
            if (board[xx][yy] == color)
            {
                if (hasOther)
                {
                    bracket = new Bracket(type,
                                          new Point(row, column),
                                          new Point(xx, yy));
                }

                break;
            }
            else if (board[xx][yy] == '-')
            {
                break;
            }
            else
            {
                hasOther = true;
            }
        }
        return bracket;
    }

    enum BracketType { LEFT, RIGHT, UP, DOWN, UP_RIGHT, UP_LEFT, DOWN_RIGHT, DOWN_LEFT};

    static class Bracket
    {
        private BracketType type = BracketType.LEFT;
        private Point start, end;

        public Bracket(BracketType type, Point start, Point end) {
            this.type   = type;
            this.start = start;
            this.end   = end;
        }

        public BracketType getType() {
            return type;
        }

        public Point getStart() {
            return start;
        }

        public Point getEnd() {
            return end;
        }
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA220 {

    final static String packName = UVA220.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA220.class, chapter);
        Main220.main(args);
    }
}