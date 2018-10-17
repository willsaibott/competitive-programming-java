package com.wip._1._3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static com.wip.Utils.defineInputMethod;

/**
 * In order to submit it in uva judge platform, remove the public modifier from the
 * class declaration, rename the class to Main and remove the package declaration
 */
public class UVA12015 {
    public static void main(String[] args) {
        defineInputMethod(args);

        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int k = 0;
        while (scanner.hasNext()) {
            List<String> output = new ArrayList<>();
            int max = -1;

            for (int ii = 0; ii < 10; ii++) {
                String url = scanner.next();
                int relevance = scanner.nextInt();

                if (relevance >= max) {
                    if (relevance > max) {
                        output.clear();
                    }
                    output.add(url);
                    max = relevance;
                }
            }

            System.out.println("Case #" + ++k + ":");
            for (String out : output) {
                System.out.println(out);
            }
        }
    }
}
