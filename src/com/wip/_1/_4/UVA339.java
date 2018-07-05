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
class Main339 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;
        boolean first = true;

        int k = 1;
        while ((line = bf.readLine()) != null && !line.equals("0 0")) {
            int rows, columns;
            int row, column;
            char[][] grid;
            StringBuilder outBuffer = new StringBuilder();
            boolean hasWinner = true;

            st =  new StringTokenizer(line);

            rows    = Integer.parseInt(st.nextToken());
            columns = Integer.parseInt(st.nextToken());
            grid    =  new char[rows][];

            for (int ii = 0; ii < rows; ii++) {
                st       = new StringTokenizer(bf.readLine());
                grid[ii] = new char[columns];

                for (int jj = 0; jj < columns; jj++) {
                    grid[ii][jj] = st.nextToken().charAt(0);
                }
            }

            st = new StringTokenizer(bf.readLine());
            while (true)
            {
                row    = Integer.parseInt(st.nextToken()) - 1;
                column = Integer.parseInt(st.nextToken()) - 1;

                if (!st.hasMoreTokens())
                {
                    st = new StringTokenizer(bf.readLine());
                }

                if (row < 0 || column < 0) break;

                if (row < rows && column < columns && grid[row][column] != ' ')
                {
                    markCells(grid, row, column, grid[row][column]);
                    removeMarkedCells(grid);
                }
            }

            if (!first) System.out.println();
            first = false;

            System.out.println("Grid " + k++ + ".");
            for (int ii = rows - 1; ii >= 0; ii--)
            {
                outBuffer.append("    ");
                for (int jj = 0; jj < columns - 1; jj++)
                {
                    outBuffer.append(grid[ii][jj]).append(' ');
                    hasWinner = hasWinner && (grid[ii][jj] == ' ');
                }

                outBuffer.append(grid[ii][columns - 1]).append("\n");
                hasWinner = hasWinner && (grid[ii][columns - 1] == ' ');
            }

            if (hasWinner)
            {
                System.out.println("    Game Won");
            }
            else
            {
                System.out.print(outBuffer.toString());
            }
        }
    }

    private static void removeMarkedCells(char[][] grid)
    {
        for (int ii = 1; ii < grid.length; ii++)
        {
            for (int jj = 0; jj < grid[ii].length; jj++)
            {
                int zz = ii - 1;
                while (zz >= 0 && grid[zz][jj] == ' ' && grid[zz + 1][jj] != ' ')
                {
                    grid[zz][jj] = grid[zz + 1][jj];
                    grid[zz + 1][jj] = ' ';
                    zz--;
                }
            }
        }

        for (int jj = 0; jj < grid[0].length - 1; jj++)
        {
            int zz = jj + 1;
            while (grid[0][jj] == ' ' && zz < grid[0].length)
            {
                for (int ii = 0; ii < grid.length; ii++)
                {
                    grid[ii][jj] = grid[ii][zz];
                    grid[ii][zz] = ' ';
                }
                zz++;
            }
        }
    }

    private static void markCells(char[][] grid, int row, int column, char value)
    {
        boolean isConnected = false;

        if (row < grid.length - 1 && grid[row + 1][column] == value)
        {
            grid[row][column] = ' ';
            grid[row + 1][column] = ' ';
            markCells(grid, row + 1, column, value);
        }

        if (row > 0 && grid[row - 1][column] == value)
        {
            grid[row - 1][column] = ' ';
            grid[row][column] = ' ';
            markCells(grid, row - 1, column, value);
        }

        if (column < grid[row].length - 1 && grid[row][column + 1] == value)
        {
            grid[row][column + 1] = ' ';
            grid[row][column] = ' ';
            markCells(grid, row, column + 1, value);
        }

        if (column > 0 && grid[row][column - 1] == value)
        {
            grid[row][column - 1] = ' ';
            grid[row][column] = ' ';
            markCells(grid, row, column - 1, value);
        }
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA339 {

    final static String packName = UVA339.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA339.class, chapter);
        Main339.main(args);
    }
}