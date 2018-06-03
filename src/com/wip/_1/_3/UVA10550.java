package com.wip._1._3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * In order to submit it in uva judge platform, remove the public modifier from the
 * class declaration, rename the class to Main and remove the package declaration
 */
public class UVA10550 {
    public static void main(String[] args) {
        defineInputMethod(args);

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int steps = 80 + 40;
            int degrees;
            int pos = scanner.nextInt();
            int[] pass = new int[3];

            for (int ii = 0; ii < 3; ii++ ) {
                pass[ii] = scanner.nextInt();
            }


            steps += (pass[0] - pos > 0) ? 40 - pass[0] + pos : pos - pass[0];
            steps += (pass[1] - pass[0] < 0) ? 40 + pass[1] - pass[0] : pass[1] - pass[0];
            steps += (pass[2] - pass[1] > 0) ? 40 - pass[2] + pass[1] : pass[1] - pass[2];

            degrees = steps * 9;

            if (steps > 120)
                System.out.println(degrees);
        }
    }

    public static void defineInputMethod(String[] args) {
        if (args.length > 0) {
            try {
                String current = new java.io.File(".").getCanonicalPath();
                System.out.println("Current dir:" + current);
                System.setIn(new FileInputStream(args[0]));
                if (args.length > 1) {
                    System.setOut(new PrintStream(new File(args[1])));
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
