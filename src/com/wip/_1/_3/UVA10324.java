package com.wip._1._3;

import java.util.Scanner;

import static com.wip.Utils.defineInputMethod;

/**
 * In order to submit it in uva judge platform, remove the public modifier from the
 * class declaration, rename the class to Main and remove the package declaration
 */
public class UVA10324 {
    public static void main(String[] args) {
        defineInputMethod(UVA10324.class);

        Scanner scanner = new Scanner(System.in);
        int testCase = 0;
        while (scanner.hasNext()) {
            String number = scanner.next();
            int size = number.length();
            int cases = scanner.nextInt();
            int[] data = new int[size];

            System.out.println("Case " + ++testCase + ":");

            data[0] = 0;
            for (int ii = 1; ii < size; ii++) {
                data[ii] = (number.charAt(ii) == number.charAt(ii - 1)) ? data[ii - 1] : data[ii - 1] + 1;
            }

            for (int kk = 0; kk < cases; kk++) {
                int i = scanner.nextInt(), j = scanner.nextInt();
                int ii = Math.min(i, j);
                int jj = Math.min(Math.max(i, j), size);
                String output = (data[ii] == data[jj]) ?  "Yes" : "No";
                System.out.println(output);
            }


//            for (int kk = 0; kk < cases; kk++) {
//                int i = scanner.nextInt(), j = scanner.nextInt();
//                int ii = Math.min(i, j);
//                int jj = Math.min(Math.max(i, j) + 1, size);
//                String output = "Yes";
//                String sub = number.substring(ii, jj);
//                int size2 = sub.length();
//                char c = sub.charAt(0);
//
//                for (int zz = 0; zz < size2; zz+= 63) {
//                    String subNumber = sub.substring(zz, Math.min(zz + 63, size2));
//                    long bits = Long.valueOf(subNumber, 2);
//                    long ones = (1l << subNumber.length()) - 1l;
//
//                    if (c == '1') {
//                        if (bits != ones) {
//                            output = "No";
//                            break;
//                        }
//                    } else {
//                        if (bits != 0) {
//                            output = "No";
//                            break;
//                        }
//                    }
//                }
//
//                System.out.println(output);
//            }
        }
    }
}
