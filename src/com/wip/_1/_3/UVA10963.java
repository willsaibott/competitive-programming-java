package com.wip._1._3;

import java.util.Scanner;

import static com.wip.Utils.defineInputMethod;

/**
 * In order to submit it in uva judge platform, remove the public modifier from the
 * class declaration, rename the class to Main and remove the package declaration
 */
public class UVA10963 {
    public static void main(String[] args) {
        defineInputMethod(args);

        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        boolean begin = true;
        while (scanner.hasNext()) {
            int columns = scanner.nextInt();
            int[] north = new int[columns];
            int[] south = new int[columns];
            int diff;
            int ii = 0;
            String output = "yes";

            if (!begin) {
                System.out.println();
            }

            begin = false;

            do
            {
                north[ii] = scanner.nextInt();
                south[ii] = scanner.nextInt();

                diff = north[ii] - south[ii];

                if (diff != north[0] - south[0]) {
                    output = "no";
                }
            } while (++ii < columns);

            System.out.println(output);
        }
    }
}
