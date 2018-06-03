package com.wip._1._3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

class UVA10911 {

    static double[] memory = new double[1 << 16];
    static double[][] dist = new double[20][20];
    static double[] x = new double[20];
    static double[] y = new double[20];
    static int target;


    public static void main(String[] args) {
        int n;
        int k = 0;
        Locale.setDefault(Locale.US);

        if(args.length > 0) {
            try {
                String current = new java.io.File( "." ).getCanonicalPath();
                System.out.println("Current dir:"+current);
                System.setIn(new FileInputStream(args[0]));

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Scanner scanner = new Scanner(System.in);
        while (true){
            n = scanner.nextInt();

            if (n <= 0) break;

            for (int ii = 0; ii < 2 * n; ii++) {
                String name = scanner.next();
                x[ii] = scanner.nextDouble();
                y[ii] = scanner.nextDouble();
            }

            calcDistance(n);

            target = (1 << 2 * n) - 1;

            setupMemory();

            System.out.printf("Case %d: %.2f\n", ++k, matching(0, n));

        }

    }

    public static void calcDistance(int n){
        for (int ii = 0; ii < 2 * n - 1; ii++) {
            for (int jj = ii + 1; jj < 2 * n; jj++) {
                dist[ii][jj] = dist[jj][ii] = Math.hypot((x[ii] - x[jj]), (y[ii] - y[jj]));
            }
        }
    }

    public static void setupMemory() {
        for (int ii = 0; ii< (1 << 16); ii++) {
            memory[ii] = -1.0;
        }
    }

    public static double matching(int bitmask, int n) {

        if (memory[bitmask] >= 0) {
            return memory[bitmask];
        }

        if (bitmask >= target) {
            return memory[bitmask] = 0;
        }

        double ans = 2000000000;
        int p1 = 0, p2 = 0;

        for (p1 = 0; p1 < 2 * n; p1++)
            if ((bitmask & (1 << p1)) == 0) break;

        for (p2 = p1 + 1; p2 < 2* n; p2++)
            if ((bitmask & (1 << p2)) == 0)
                ans = Math.min(ans, dist[p1][p2] + matching(bitmask | (1 << p1) | (1 << p2), n));

        return memory[bitmask] = ans;
    }
}
