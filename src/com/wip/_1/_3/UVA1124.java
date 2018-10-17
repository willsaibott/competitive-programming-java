package com.wip._1._3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * In order to submit it in uva judge platform, remove the public modifier from the
 * class declaration, rename the class to Main and remove the package declaration
 */
public class UVA1124 {
    public static void main(String[] args) {
        defineInputMethod(args);

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
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
