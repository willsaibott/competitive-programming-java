package com.wip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Locale;

public class Utils {

    public static void defineInputMethod(String[] args) {
        if (args.length > 1) {
            try {
                String filename = args[0];
                String current = new File(".").getCanonicalPath();
                System.out.println("Current dir:" + current);

                Locale.setDefault(Locale.US);
                String chapter = args[1].substring(0, args[1].indexOf("."));
                String sub = args[1].substring(args[1].indexOf(".") + 1);
                System.setIn(new FileInputStream("input/" + chapter + "/" + sub + "/" + filename));
                System.setOut(new PrintStream(new File("output/" + chapter + "/" + sub + "/" + filename)));

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void defineInputMethod(Class myClass) {
        String className =  myClass.getSimpleName();
        defineInputMethod(new String[] { className.substring(3), "1.3" });
    }

    public static void defineInputMethod(Class myClass, String path) {
        String className =  myClass.getSimpleName();
        defineInputMethod(new String[] { className.substring(3), path });
    }
}
