package com.wip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Locale;

public class Utils {

    public static void defineInputMethod(String[] args) {
        if (args.length > 0) {
            try {
                String filename = args[0];
                String current = new File(".").getCanonicalPath();
                System.out.println("Current dir:" + current);

                Locale.setDefault(Locale.US);
                System.setIn(new FileInputStream("input/_1/_3/" + filename));
                System.setOut(new PrintStream(new File("output/1.3/" + filename)));

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
