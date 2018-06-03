package com.wip._1._3;

import java.util.Scanner;

import static com.wip.Utils.defineInputMethod;

/**
 * In order to submit it in uva judge platform, remove the public modifier from the
 * class declaration, rename the class to Main and remove the package declaration
 */
public class UVA12468 {
    public static void main(String[] args) {
        defineInputMethod(args);

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            if (a < 0 || b < 0) break;

            int press = Math.min(Math.abs(a - b), Math.abs(a - b + 100));
            press = Math.min(press, Math.abs(a - b - 100));

            System.out.println(press);
        }
    }
}
