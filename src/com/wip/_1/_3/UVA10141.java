package com.wip._1._3;

import java.util.HashMap;
import java.util.Scanner;

import static com.wip.Utils.defineInputMethod;

/**
 * In order to submit it in uva judge platform, remove the public modifier from the
 * class declaration, rename the class to Main and remove the package declaration
 */
public class UVA10141 {
    public static void main(String[] args) {
        defineInputMethod(UVA10141.class);

        Scanner scanner = new Scanner(System.in);
        int testCase = 0;
        while (scanner.hasNext()) {
            int requirements = scanner.nextInt();
            int proposals = scanner.nextInt();
            String[] reqs = new String[requirements];
            int max = 0;
            double minPrice = Double.MAX_VALUE;
            String output = "";

            if (requirements <= 0) break;
            scanner.nextLine();
            for (int ii = 0; ii < requirements; ii++) {
                reqs[ii] = scanner.nextLine();
            }

            for (int ii = 0; ii< proposals; ii++) {
                String name = scanner.nextLine();
                double price = scanner.nextDouble();
                int met = scanner.nextInt();

                for (int jj = 0; jj <= met; jj++) {
                    String reqName = scanner.nextLine();
                }

                if (met > max || (met == max) && (price < minPrice)) {
                    output = name;
                    minPrice = price;
                    max = met;
                }
            }

            if (testCase>0) System.out.println();
            if (requirements > 0)
                System.out.println("RFP #" + ++testCase + "\n" + output);

        }
    }
}
