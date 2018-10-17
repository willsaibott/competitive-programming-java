package com.wip._1._3;

import java.util.Scanner;
import static com.wip.Utils.defineInputMethod;

/**
 * In order to submit it in uva judge platform, remove the public modifier from the
 * class declaration, rename the class to Main and remove the package declaration
 */
public class UVA10300 {
    public static void main(String[] args) {
        defineInputMethod(args);

        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        while (scanner.hasNext()) {
            int farmers = scanner.nextInt();
            long[] size = new long[farmers];
            long[] animals = new long[farmers];
            long[] envFriend = new long[farmers];
            double[] averages = new double[farmers];
            long premium = 0;

            for (int ii = 0; ii < farmers; ii++) {
                size[ii] = scanner.nextInt();
                animals[ii] = scanner.nextInt();
                envFriend[ii] = scanner.nextInt();

                premium += size[ii] *envFriend[ii];
            }

            System.out.println(premium);
        }
    }
}
