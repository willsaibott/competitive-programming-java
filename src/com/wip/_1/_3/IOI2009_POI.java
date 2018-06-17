package com.wip._1._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

import static com.wip.Utils.defineInputMethod;

/**
 * In order to submit it in uva judge platform, remove the public modifier from the
 * class declaration, rename the class to Main and remove the package declaration
 */
public class IOI2009_POI {
    public static void main(String[] args) throws IOException {
        defineInputMethod(args);

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;

        int k = 0;
        while ((line = bf.readLine()) != null && !line.equals("0")) {
            st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            Contestant[] contestants = new Contestant[n];


            for (int ii = 0; ii < n; ii++)
            {
                contestants[ii] = new Contestant(bf.readLine().toCharArray());
            }

            Arrays.sort(contestants, new Comparator<Contestant>()
            {

                @Override
                public int compare(Contestant c1, Contestant c2) {

                    int diff1 = c2.getScore() - c1.getScore();
                    int diff2 = c2.getTasks() - c1.getTasks();
                    int diff3 = c1.getId() - c2.getId();
                    return (diff1 != 0 ? diff1 :
                            (diff2 != 0 ? diff2 : diff3));
                }
            });

            int ii;
            for (ii = 1; ii <= n; ii++)
                if (p == contestants[ii].getId())
                    break;
            System.out.println(contestants[ii].getScore() + " " + (ii + 1));
        }
    }
}

class Contestant
{
    private static int count = 0;
    private static int[] weights = new int[2000];
    private static HashMap<Integer, Integer> map = new HashMap<>();

    private ArrayList<Integer> tasks = new ArrayList<>();
    private int id;
    private int score = -1;

    public Contestant(char[] tasks) {
        this.id = ++count;

        for (int ii = 0; ii < tasks.length; ii++)
        {
            if (tasks[ii] == '1')
            {
                this.tasks.add(ii);
            }
            else if (tasks[ii] == '0')
            {
                weights[ii]++;
            }
        }
    }

    public int getId() {
        return id;
    }

    public int getScore() {

        if (score == -1)
        {
            score = 0;
            for (int ii : tasks)
            {
                score += weights[ii];
            }
        }
        return score;
    }

    public int getTasks() {
        return tasks.size();
    }

    public static int getContestantPosition(Contestant c)
    {
        return map.get(c.getId());
    }
}