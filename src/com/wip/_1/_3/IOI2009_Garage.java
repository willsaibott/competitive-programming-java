package com.wip._1._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.ArrayBlockingQueue;

import static com.wip.Utils.defineInputMethod;

/**
 * In order to submit it in uva judge platform, remove the public modifier from the
 * class declaration, rename the class to Main and remove the package declaration
 */
public class IOI2009_Garage {
    static int[] parked = new int[101];
    static long[] rates = new long[101];
    static long[] weights = new long[2001];
    static long cost = 0;
    static int position = 0;
    static HashMap<Integer, Integer> car2space = new HashMap<>();
    static HashMap<Integer, Integer> space2car = new HashMap<>();

    public static void main(String[] args) throws IOException {
        defineInputMethod(args);

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;

        int k = 0;

        while ((line = bf.readLine()) != null) {
            st = new StringTokenizer(line);
            int spaces = Integer.parseInt(st.nextToken());
            int cars = Integer.parseInt(st.nextToken());
            int count = 0;
            cost = 0;
            position = 1;

            LinkedList<Integer> queue = new LinkedList<>();


            for (int ii = 1; ii <= spaces; ii++)
            {
                rates[ii] = Integer.parseInt(bf.readLine());
            }

            for (int ii = 1; ii <= cars; ii++)
            {
                weights[ii] = Integer.parseInt(bf.readLine());
            }

            for (int ii = 1; ii <= 2*cars; ii++ )
            {
                int car = Integer.parseInt(bf.readLine());

                if (car > 0)
                {
                    if (count < spaces)
                    {
                        park(car);
                        count++;
                    }
                    else
                    {
                        queue.addLast(car);
                    }
                }
                else
                {
                    exitPark(-car);
                    if (count >= spaces && !queue.isEmpty())
                    {
                        park(queue.removeFirst());
                    }
                    else
                    {
                        count--;
                    }
                }
            }

            // cost = weight(kg) * rate of parking space

            System.out.println(cost);

            car2space.clear();
            space2car.clear();
        }
    }

    public static int getNextAvailablePosition()
    {
        int ii = 1;
        while (ii < 101 && parked[ii] != 0) ii++;
        return ii;
    }

    public static void park(int car)
    {
        cost += rates[position] * weights[car];
        parked[position] = car;
        car2space.put(car, position);

        position = getNextAvailablePosition();
    }

    public static void exitPark(int car)
    {
        int pos = car2space.get(car);
        parked[pos] = 0;
        car2space.remove(car);

        if (pos <= position)
        {
            position = pos;
        }
        else
        {
            position = getNextAvailablePosition();
        }
    }
}
