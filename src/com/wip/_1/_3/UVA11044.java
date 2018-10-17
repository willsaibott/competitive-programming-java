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
public class UVA11044 {
    public static void main(String[] args) {
        defineInputMethod(args);

        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        while (scanner.hasNext()) {
            int min = 0;
            int n = scanner.nextInt() - 2;
            int m = scanner.nextInt() - 2;

            min = (n % 3 != 0 ? n/3 + 1 : n/3)  * ((m % 3 != 0 ? m/3 + 1 : m/3) );

            System.out.println(min);
        }
    }

    public static void defineInputMethod(String[] args) {
        if (args.length > 0) {
            try {
                String filename = "uva" + args[0] + ".txt";
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
