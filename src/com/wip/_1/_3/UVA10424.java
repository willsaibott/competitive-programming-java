package com.wip._1._3;

import java.util.Scanner;

import static com.wip.Utils.defineInputMethod;

/**
 * In order to submit it in uva judge platform, remove the public modifier from the
 * class declaration, rename the class to Main and remove the package declaration
 */
public class UVA10424 {
    public static void main(String[] args) {
        defineInputMethod(UVA10424.class);

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String name1 = scanner.nextLine();
            String name2 = scanner.nextLine();
            double sum1 = calculateSum(name1);
            double sum2 = calculateSum(name2);
            double ratio = Math.min(sum2 / sum1,  sum1 /sum2);

            System.out.printf("%.2f %%\n", 100.00 * ratio);
        }
    }

    private static double calculateSum(String name1) {
        double sum = 0;
        for (char c : name1.toCharArray()) {
            if (c >= 'a' && c <= 'z'){
                sum += c - 'a' + 1;
            } else if (c >= 'A' && c <= 'Z'){
                sum += c - 'A' + 1;
            }
        }
        return calculateSum2((int)sum);
    }

    private static double calculateSum2(int number) {
        int sum = 0;
        int n = number;

        while (n / 10 != 0) {
            sum += n % 10;
            n /= 10;
        }

        sum += n;

        return (sum == number)? sum : calculateSum2(sum);
    }
}
