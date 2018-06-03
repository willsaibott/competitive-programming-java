package com.wip._1._3;

import java.util.Scanner;

import static com.wip.Utils.defineInputMethod;

/**
 * In order to submit it in uva judge platform, remove the public modifier from the
 * class declaration, rename the class to Main and remove the package declaration
 */
public class UVA11764 {
    public static void main(String[] args) {
        defineInputMethod(args);

        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseI = 0;
        while (scanner.hasNext()) {
            int heights = scanner.nextInt();
            int high = 0, low = 0;
            int last = scanner.nextInt();

            for (int ii = 1; ii < heights; ii++) {
                int next = scanner.nextInt();
                if (next > last) {
                    high++;
                } else if ( next < last) {
                    low++;
                }

                last = next;
            }

            System.out.printf("Case %d: %d %d\n", ++caseI, high, low);
        }
    }
}
