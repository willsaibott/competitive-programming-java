package com.wip._1._3;

import java.util.Scanner;

import static com.wip.Utils.defineInputMethod;

/**
 * In order to submit it in uva judge platform, remove the public modifier from the
 * class declaration, rename the class to Main and remove the package declaration
 */
public class UVA11799 {
    public static void main(String[] args) {
        defineInputMethod(args);

        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseI = 0;
        while (scanner.hasNext()) {
            int creaures = scanner.nextInt();
            int max = 0;

            for (int ii = 0; ii < creaures; ii++) {
                max = Math.max(max, scanner.nextInt());
            }

            System.out.printf("Case %d: %d\n", ++caseI, max);
        }
    }
}
