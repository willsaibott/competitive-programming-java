package com.wip._1._3;

import java.util.Scanner;

import static com.wip.Utils.defineInputMethod;

/**
 * In order to submit it in uva judge platform, remove the public modifier from the
 * class declaration, rename the class to Main and remove the package declaration
 */
public class UVA11559 {
    public static void main(String[] args) {
        defineInputMethod(args);

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int people = scanner.nextInt();
            double budget = scanner.nextDouble();
            int hotels = scanner.nextInt();
            int weekends = scanner.nextInt();
            int[] beds = new int[weekends];
            double min = Double.POSITIVE_INFINITY;

            for (int ii = 0; ii < hotels; ii++) {
                double price = scanner.nextDouble();
                double total = price * people;

                for (int jj =  0; jj < weekends; jj++) {
                    beds[jj] = scanner.nextInt();

                    if ((beds[jj] >= people) &&
                        (total <= budget))
                    {
                        min = Math.min(min, total);
                    }
                }
            }

            if (min < Double.POSITIVE_INFINITY)
            {
                System.out.println((int)min);
            } else {
                System.out.println("stay home");
            }
        }
    }
}
