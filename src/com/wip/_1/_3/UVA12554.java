package com.wip._1._3;

import java.util.ArrayList;
import java.util.Scanner;

import static com.wip.Utils.defineInputMethod;

/**
 * In order to submit it in uva judge platform, remove the public modifier from the
 * class declaration, rename the class to Main and remove the package declaration
 */
public class UVA12554 {
    public static void main(String[] args) {
        defineInputMethod(args);

        String[] song = "Happy birthday to you Happy birthday to you Happy birthday to Rujia Happy birthday to you".split(" ");

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int persons = scanner.nextInt();
            int iterator = 0;
            boolean allSing = false;
            ArrayList<String> names = new ArrayList<>();


            for (int ii = 0; ii < persons; ii++) {
                names.add(scanner.next());
            }

            do {
                for (String word: song) {
                    System.out.println(names.get(iterator++) + ": " + word);

                    if (iterator >= names.size()) {
                        iterator = 0;
                        allSing = true;
                    }

                }
            } while (!allSing);
        }
    }
}
