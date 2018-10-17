package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main141 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;

        while ((line = bf.readLine()) != null && !line.equals("0")) {
            String output = "Draw";
            int n = Integer.parseInt(line);
            int size = 2 * n;
            boolean isOver = false;
            ArrayList<HashSet<Point>> boardsArray = new ArrayList<>();
            HashSet<Point> currentBoard = new HashSet<>();

            for (int ii = 0; ii < size; ii++)
            {
                line = bf.readLine();

                if (!isOver)
                {
                    HashSet<Point> next = (HashSet<Point>) currentBoard.clone();
                    int x , y;

                    st = new StringTokenizer(line);
                    x = Integer.parseInt(st.nextToken()) - 1;
                    y = Integer.parseInt(st.nextToken()) - 1;

                    if (st.nextToken().equals("+"))
                    {
                        next.add(new Point(x, y));
                    }
                    else
                    {
                        next.remove(new Point(x, y));
                    }

                    for (HashSet<Point> points : boardsArray) {

                        isOver = isOver ||
                                 isRotatedPlus90(points, next, n) ||
                                 isRotatedMinus90(points, next, n) ||
                                 isRotatedPlus180(points, next, n) ||
                                 points.equals(next);

                        if (isOver)
                        {
                            int winner = ((ii + 1) & 1) + 1;
                            output = "Player " + winner + " wins on move " + (ii + 1);
                            break;
                        }
                    }
                    boardsArray.add(currentBoard = next);
                }
            }

            //System.out.println(output +"\t input: " + n + " line :" + k);
            System.out.println(output);
        }
    }

    public static boolean isRotatedPlus90(HashSet<Point> board,
                                          HashSet<Point> nextBoard,
                                          int gridSize)
    {
        int length = board.size();

        if (nextBoard.size() != length) return false;

        for (Point point : nextBoard) {
            if (!board.contains(new Point(point.y, gridSize - 1 - point.x)))
                return false;
        }

        return true;
    }

    public static boolean isRotatedMinus90(HashSet<Point> board,
                                           HashSet<Point> nextBoard,
                                           int gridSize)
    {
        int length = board.size();

        if (nextBoard.size() != length) return false;

        for (Point point : nextBoard) {
            if (!board.contains(new Point(gridSize - 1 - point.y, point.x)))
                return false;
        }

        return true;
    }

    public static boolean isRotatedPlus180(HashSet<Point> board,
                                           HashSet<Point> nextBoard,
                                           int gridSize)
    {
        int length = board.size();

        if (nextBoard.size() != length) return false;

        for (Point point : nextBoard) {
            if (!board.contains(new Point(gridSize - 1 - point.x, gridSize - 1 - point.y)))
                return false;
        }

        return true;
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA141 {

    final static String packName = UVA141.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA141.class, chapter);
        Main141.main(args);
    }
}
