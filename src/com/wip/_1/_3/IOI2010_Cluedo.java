package com.wip._1._3;

import java.util.Scanner;

import static com.wip.Utils.defineInputMethod;

/**
 * In order to submit it in uva judge platform, remove the public modifier from the
 * class declaration, rename the class to Main and remove the package declaration
 */
public class IOI2010_Cluedo {


    public static int theoryCalls = 0;
    public static int m, l, w;

    public static void main(String[] args) {
        defineInputMethod(args);

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            theoryCalls = 0;
            m = scanner.nextInt();
            l = scanner.nextInt();
            w = scanner.nextInt();

            Solve();

            System.out.println(theoryCalls);
        }
    }

    private static void Solve() {
        int[] test = { 0, 1, 1, 1 };
        int ii = 0;

        do{
            ii = Theory(test[1], test[2], test[3]);
            if (ii != 0) test[ii]++;
        } while (ii != 0);

    }

    private static int Theory(int m_theory, int l_theory, int w_theory) {
        theoryCalls++;

        if (m_theory < 1 || m_theory > 6 || l_theory < 1 || l_theory > 10 || w_theory < 1 || w_theory > 6)
            return 91;
        if (Math.round(Math.random()) == 1 && m != m_theory) return 1;
        else if (Math.round(Math.random()) == 1 && l != l_theory) return 2;
        else if (Math.round(Math.random()) == 1 && w != w_theory) return 3;
        else if (m != m_theory) return 1;
        else if (l != l_theory) return 2;
        else if (w != w_theory) return 3;
        return 0;
    }

}
