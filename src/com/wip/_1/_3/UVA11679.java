package com.wip._1._3;

import java.util.Scanner;

import static com.wip.Utils.defineInputMethod;

/**
 * In order to submit it in uva judge platform, remove the public modifier from the
 * class declaration, rename the class to Main and remove the package declaration
 */
public class UVA11679 {
    public static void main(String[] args) {
        defineInputMethod(args);

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int banks = scanner.nextInt();
            int debentures = scanner.nextInt();
            int[] reserves = new int[banks + 1];
            String output = "S";

            if (banks == 0 && debentures == 0) break;

            for (int ii = 1; ii <= banks; ii++) {
                reserves[ii] = scanner.nextInt();
            }

            for (int ii = 0; ii < debentures; ii++) {
                int debtorBank = scanner.nextInt();
                int creditorBank = scanner.nextInt();
                int debit = scanner.nextInt();

                reserves[debtorBank] -= debit;
                reserves[creditorBank] += debit;
            }

            for (int ii = 1; ii <= banks; ii++) {
                if (reserves[ii] < 0) {
                    output = "N"; break;
                }
            }

            System.out.println(output);
        }
    }
}
