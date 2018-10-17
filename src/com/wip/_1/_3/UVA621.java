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
public class UVA621 {
    public static void main(String[] args) {
        defineInputMethod(args);

        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (scanner.hasNext()) {
            String term = scanner.next();
            ProcessEvaluate processEvaluate = new ProcessEvaluate(term);

            System.out.println(processEvaluate.evaluate());
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

    private static class ProcessEvaluate
    {
        String term;
        String _1 = "1", _4 = "4", _78="78", _35 = "35",
               _9 = "9", _190="190";

        ProcessEvaluate(String term){
            this.term = term;
        }

        String evaluate() {
            return evaluate(term);
        }

        String evaluate(String str) {

            if (str.endsWith(_35)) {
                String begin = str.substring(0, str.lastIndexOf(_35));
                String eval = evaluate(begin);
                return "-";
            }

            if (str.startsWith(_9) && str.endsWith(_4)) {
                String middle = str.substring(str.indexOf(_9) + 1,
                                              str.lastIndexOf(_4));
                String eval = evaluate(middle);
                return "*";
            }

            if (str.startsWith(_190)) {

                String subTerm = evaluate(str.substring(str.indexOf(_190) + 3));
                return "?";
            }

            if (str.contains(_1) || str.contains(_4) || str.contains(_78)) {
                return "+";
            }

            return "null";
        }
    }
}
