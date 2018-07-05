package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main114 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line = bf.readLine();
        String output;
        int m, n;
        int wall = Integer.parseInt(bf.readLine());
        int p    = Integer.parseInt(bf.readLine());
        int total = 0;
        Bumper[] bumpers = new Bumper[p];
        HashMap<Point, Bumper> grid = new HashMap<>();

        st = new StringTokenizer(line);
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        for (int ii = 0; ii < p; ii++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            bumpers[ii] = new Bumper(x, y, cost, value);
            grid.put(new Point(x, y), bumpers[ii]);
        }

        while ((line = bf.readLine()) != null) {
            Ball ball;

            st = new StringTokenizer(line);
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            int life = Integer.parseInt(st.nextToken());

            ball = new Ball(x, y, life, direction);

            while (ball.getLife() > 0)
            {
                Point next = ball.nextPosition();
                boolean hit = false;

                if (((next.x >= m) || (next.x <= 1)) ||
                    ((next.y >= n) || (next.y <= 1)))
                {
                    ball.hit(wall);
                    hit = true;
                }
                else
                {
                    Bumper bumper = grid.get(next);
                    hit = bumper != null;
                    ball.hit(bumper);
                }

                if (!hit)
                    ball.stepRun();

            }

            System.out.println(ball.getValue());

            total += ball.getValue();
        }

        System.out.println(total);
    }

    static class Ball extends Point
    {
        private int life;
        private int direction;
        private int value = 0;

        public Ball(int x, int y, int life, int direction) {
            super(x, y);
            this.life = life;
            this.direction = direction;
        }

        public int getLife() {
            return life;
        }

        public int getDirection() {
            return direction;
        }

        public int getValue() {
            return value;
        }

        public void hit(Bumper hitBumper)
        {
            if (hitBumper != null)
            {
                if (life - 1 > 0)
                {
                    value += hitBumper.getValue();
                    hit(hitBumper.getCost());
                }
                else
                {
                    life--;
                }
            }
        }

        public void hit(int cost)
        {
            direction = (direction  + 3) & 3; //  rest of division by 4
            life = Math.max(life - (cost + 1), 0);
        }

        public void stepRun()
        {
            this.setLocation(nextPosition());
            life--;
        }

        public Point nextPosition()
        {
            switch (direction)
            {
                case 0:
                    return new Point(x + 1, y);
                case 1:
                    return new Point(x, y + 1);
                case 2:
                    return new Point(x - 1, y);
                case 3:
                    return new Point(x, y - 1);
                default:
                    throw new RuntimeException("Invalid Direction");
            }
        }

        @Override
        public String toString() {
            return "Position: (" + x + ", " + y + "). Life: " + life +
                   ". DIrection: " + direction;
        }
    }

    static class Bumper extends Point
    {
        private int cost;
        private int value;

        Bumper(int x, int y, int cost, int value)
        {
            super(x, y);
            this.cost = cost;
            this.value = value;
        }

        public int getCost() {
            return cost;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Position: (" + x + ", " + y + "). Value: " + value +
                    ". Cost: " + cost;
        }
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA114 {

    final static String packName = UVA114.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA114.class, chapter);
        Main114.main(args);
    }
}