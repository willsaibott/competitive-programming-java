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
public class UVA11364 {
    public static void main(String[] args) {
        defineInputMethod(args);

        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int k = 0;

        while (scanner.hasNext()) {
            int parkAt = 0;
            int places = scanner.nextInt();
            int[] pos = new int[places];
            int dist = 0;
            int max = -1;
            int min = 100000000;

            for (int ii = 0; ii < places ; ii++) {
                pos[ii] = scanner.nextInt();
                max = Math.max(pos[ii], max);
                min = Math.min(pos[ii], min);
            }

            System.out.println(2 * (max - min));
        }
    }

    public static void defineInputMethod(String[] args) {
        if (args.length > 0) {
            try {
                String filename = args[0];
                String current = new File(".").getCanonicalPath();
                System.out.println("Current dir:" + current);

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
