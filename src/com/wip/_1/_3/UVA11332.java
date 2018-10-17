package com.wip._1._3;

import java.util.HashMap;
import java.util.Scanner;

import static com.wip.Utils.defineInputMethod;

/**
 * In order to submit it in uva judge platform, remove the public modifier from the
 * class declaration, rename the class to Main and remove the package declaration
 */
public class UVA11332 {

    static HashMap<Long, Long> memory = new HashMap<Long, Long>();
    public static void main(String[] args) {
        defineInputMethod(args);

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            long number = scanner.nextLong();

            if (number > 0) {
                System.out.println(sumDigits(number));
            } else {
                break;
            }
        }
    }

    public static long sumDigits(long number) {

        long sum = 0;

        if (memory.get(number) != null) return memory.get(number);

        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }

        memory.put(number, sum);
        return (sum < 10) ? sum : sumDigits(sum);
    }
}
