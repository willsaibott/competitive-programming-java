package com.wip._1._3;

import java.util.Scanner;

import static com.wip.Utils.defineInputMethod;

/**
 * In order to submit it in uva judge platform, remove the public modifier from the
 * class declaration, rename the class to Main and remove the package declaration
 */
public class UVA12157 {
    public static void main(String[] args) {
        defineInputMethod(args);

        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int k = 0;
        while (scanner.hasNext()) {
            int callDurations = scanner.nextInt();
            int mile = 0, juice = 0;
            String output = "Case " + ++k + ": ";

            for (int ii = 0; ii < callDurations; ii++) {
                int duration = scanner.nextInt();
                mile += (duration / 30 + 1) * 10;
                juice += (duration / 60 + 1) * 15;
            }

            if (mile < juice) {
                output += "Mile " + mile;
            } else if (juice < mile) {
                output += "Juice " + juice;
            } else {
                output += "Mile Juice " + mile;
            }

            System.out.println(output);
        }
    }
}
