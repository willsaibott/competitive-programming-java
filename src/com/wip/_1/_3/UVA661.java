package com.wip._1._3;

import java.util.Scanner;

import static com.wip.Utils.defineInputMethod;

/**
 * In order to submit it in uva judge platform, remove the public modifier from the
 * class declaration, rename the class to Main and remove the package declaration
 */
public class UVA661 {

    public static void main(String[] args) {
        defineInputMethod(UVA661.class);

        Scanner scanner = new Scanner(System.in);
        int k = 0;
        while (scanner.hasNext()) {
            boolean fuseBlown = false;
            String outputTrue = "Fuse was not blown.\nMaximal power consumption was bla amperes.\n";
            String outputFalse = "Fuse was blown.\n";
            String output = outputFalse;
            int max= 0;
            int current = 0;
            int bitmask = 0;
            int devices = scanner.nextInt();
            int operations = scanner.nextInt();
            int[] consumptions = new int[devices];
            int capcity = scanner.nextInt();


            for (int ii = 0; ii< devices; ii++) {
                consumptions[ii] = scanner.nextInt();
            }

            for (int ii = 0; ii < operations; ii++) {
                int operation = scanner.nextInt() - 1;
                int turnedOn = bitmask & (1 << operation);

                if (turnedOn != 0) {
                    current -= consumptions[operation];
                    bitmask &= ~(1 << operation);
                } else {
                    current += consumptions[operation];
                    bitmask |= (1 << operation);
                }

                max = Math.max(current, max);

                if (max > capcity) fuseBlown = true;
            }

            if (devices > 0) {
                output = (fuseBlown) ? output :  outputTrue.replace("bla", "" + max);
                System.out.println("Sequence " + ++k);
                System.out.println(output);
            }
        }
    }
}
