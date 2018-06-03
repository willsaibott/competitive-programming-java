package com.wip._1._3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;

/**
 * In order to submit it in uva judge platform, remove the public modifier from the
 * class declaration, rename the class to Main and remove the package declaration
 */
public class UVA10114 {

    static double[] depr;
    static int[]  month;
    static double down;
    static double loan;
    static int months;
    static int records;
    static double plots;

    public static void main(String[] args) {
        defineInputMethod(args);

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            months = scanner.nextInt();

            if (months <= 0) break;

            down    = scanner.nextDouble();
            loan    = scanner.nextDouble();
            records = scanner.nextInt();
            depr    = new double[months + 1];
            month   = new int[records];
            plots   = loan / months;

            for (int ii = 0; ii < records; ii++) {
                month[ii] = scanner.nextInt();
                depr[month[ii]] = 1 - scanner.nextDouble();

                for (int jj = month[ii] + 1; jj < depr.length ; jj++) {
                    depr[jj] = depr[month[ii]];
                }
            }


            int eval = evaluate();
            if (eval != 1) {
                System.out.println(eval + " months");
            } else {
                System.out.println(eval + " month");
            }
        }
    }

    public static int evaluate() {
        double owe = loan;
        double price = (loan + down) * (depr[0]);
        int ii = 0;

        while (owe >= price && ii++ < months)
        {
            owe -= plots;
            price *=  (depr[ii]);
        }

        return ii;
    }

    public static void defineInputMethod(String[] args) {
        if (args.length > 0) {
            try {
                String filename = args[0];
                String current = new File(".").getCanonicalPath();
                System.out.println("Current dir:" + current);

                Locale.setDefault(Locale.US);
                System.setIn(new FileInputStream("input/" + filename));
                System.setOut(new PrintStream(new File("output/" + filename)));

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
