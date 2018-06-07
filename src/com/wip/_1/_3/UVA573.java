package com.wip._1._3;

import java.util.Scanner;

import static com.wip.Utils.defineInputMethod;

/**
 * In order to submit it in uva judge platform, remove the public modifier from the
 * class declaration, rename the class to Main and remove the package declaration
 */
public class UVA573 {
    public static void main(String[] args) {
        defineInputMethod(args);

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            double height;
            double initial = height = scanner.nextInt();
            double climb  = scanner.nextInt();
            double slide  = scanner.nextInt();
            double fadigue = climb * 0.01 * scanner.nextDouble();
            int day = 0;
            String output = "failure on day ";

            do{
                climb = (climb < 0) ? 0 : climb;
                height -= climb; day++;

                if (height >= 0) {
                    height += slide;
                    climb -= fadigue;
                }
            } while (height > 0 && height <= initial);

            if (initial > 0) {
                output = (height > 0) ? output + day : output.replace("failure", "success") + day;
                System.out.println(output);
            }
        }
    }
}
