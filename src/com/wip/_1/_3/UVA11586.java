package com.wip._1._3;

import java.util.Scanner;

import static com.wip.Utils.defineInputMethod;

/**
 * In order to submit it in uva judge platform, remove the public modifier from the
 * class declaration, rename the class to Main and remove the package declaration
 */
public class UVA11586 {
    public static void main(String[] args) {
        defineInputMethod(UVA11586.class);

        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        while (scanner.hasNext()) {
            String[] tracks = scanner.nextLine().split(" ");
            String output = "NO LOOP";
            int m, f;

            if (tracks.length > 1) {
                m = f  = 0;

                for (String track : tracks) {
                    switch (track) {
                        case "FM":
                        case "MF": f++; m++; break;
                        case "FF": f += 2; break;
                        case "MM": m += 2; break;
                        default: break;
                    }
                }

                if (m == f)
                    output = "LOOP";
            }

            System.out.println(output);
        }
    }
}
