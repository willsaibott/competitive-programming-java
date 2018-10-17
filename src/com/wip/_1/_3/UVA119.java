package com.wip._1._3;

import java.util.HashMap;
import java.util.Scanner;

import static com.wip.Utils.defineInputMethod;

/**
 * In order to submit it in uva judge platform, remove the public modifier from the
 * class declaration, rename the class to Main and remove the package declaration
 */
public class UVA119 {
    public static void main(String[] args) {
        defineInputMethod(args);

        Scanner scanner = new Scanner(System.in);
        boolean begin = true;
        while (scanner.hasNext()) {
            int people = scanner.nextInt();
            HashMap<String, Integer> map = new HashMap<>();
            scanner.nextLine();
            String[] names = scanner.nextLine().split(" ");

            if (!begin) System.out.println();
            begin = false;

            for (int ii = 0; ii < people; ii++) {
                String giver = scanner.next();
                int money = scanner.nextInt();
                int receivers = scanner.nextInt();
                int gift = receivers > 0 ? money / receivers : 0;
                int totalSpent = gift * receivers;
                int rest = money - totalSpent;
                updateBalance(map, giver, rest - money);

                for (int jj = 0; jj < receivers; jj++) {
                    String receiver = scanner.next();
                    updateBalance(map, receiver, gift);
                }
            }

            for (String name : names) {
                System.out.println(name + " " + map.get(name));
            }
        }
    }


    static void updateBalance(HashMap<String, Integer> map, String name, int value) {
        map.put(name, map.containsKey(name) ? map.get(name) + value : value);
    }
}
