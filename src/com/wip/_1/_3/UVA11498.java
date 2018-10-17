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
public class UVA11498 {
    public static void main(String[] args) {
        defineInputMethod(args);

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int queries = scanner.nextInt();

            if (queries <= 0) continue;

            int x0 = scanner.nextInt();
            int y0 = scanner.nextInt();
            int[] x = new int[queries];
            int[] y = new int[queries];

            for (int ii = 0; ii < queries; ii++) {
                String output = "divisa";

                x[ii] = scanner.nextInt();
                y[ii] = scanner.nextInt();

                if (x[ii] > x0){
                    if (y[ii] > y0) {
                        output = "NE";
                    } else if (y[ii]  < y0) {
                        output = "SE";
                    }
                } else if (x[ii] < x0){
                    if (y[ii] > y0) {
                        output = "NO";
                    } else if (y[ii]  < y0) {
                        output = "SO";
                    }
                }

                System.out.println(output);
            }
        }
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
