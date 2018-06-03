package com.wip._1._3;

import java.util.Scanner;

import static com.wip.Utils.defineInputMethod;

/**
 * In order to submit it in uva judge platform, remove the public modifier from the
 * class declaration, rename the class to Main and remove the package declaration
 */
public class UVA12503 {
    public static void main(String[] args) {
        defineInputMethod(args);

        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        while (scanner.hasNext()) {
            int position = 0;
            int instructions = scanner.nextInt();
            int[] memory = new int[instructions + 1];
            String line = scanner.nextLine();

            for (int ii = 1; ii <= instructions; ii++) {
                line = scanner.nextLine();


                if (line.equals("LEFT")) {
                    memory[ii] = -1;
                } else if (line.equals("RIGHT")) {
                    memory[ii] = 1;
                } else {
                    memory[ii] = memory[Integer.valueOf(line.substring(line.lastIndexOf("S") + 1).trim())];
                }
                position += memory[ii];
            }

            System.out.println(position);
        }
    }
}
