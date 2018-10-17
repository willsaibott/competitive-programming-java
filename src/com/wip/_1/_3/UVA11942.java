package com.wip._1._3;

import java.util.Scanner;

import static com.wip.Utils.defineInputMethod;

/**
 * In order to submit it in uva judge platform, remove the public modifier from the
 * class declaration, rename the class to Main and remove the package declaration
 */
public class UVA11942 {
    public static void main(String[] args) {
        defineInputMethod(args);

        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        System.out.println("Lumberjacks:");
        while (scanner.hasNext()) {
            String output = "Ordered";
            int first = scanner.nextInt();
            int last = scanner.nextInt();
            boolean asc = (first <= last);

            for (int ii = 2; ii < 10; ii++) {
                int next = scanner.nextInt();

                if (asc && (last > next) || !asc && (last < next))
                {
                    output = "Unordered";
                }

                last = next;
            }

            System.out.println(output);
        }
    }
}
