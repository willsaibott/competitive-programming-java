package com.wip._1._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.wip.Utils.defineInputMethod;

/**
 * In order to submit it in uva judge platform, remove the public modifier from the
 * class declaration, rename the class to Main and remove the package declaration
 */
public class UVA11661 {
    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA11661.class);

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String l;
        while ((l = bf.readLine()) != null && !l.equals("0") && !l.equals("0 0")) {
            int length = Integer.parseInt(l);
            if (length == 0) break;

            char[] highway = bf.readLine().toCharArray();
            int ii = 0;
            while (highway[ii] == '.') ii++;
            char last = highway[ii];
            int dist = Integer.MAX_VALUE;

            for (int jj = ii; jj < highway.length; jj++ ) {

                if (highway[jj] == 'Z') {
                    dist = 0;
                    break;
                } else if (highway[jj] != '.' && highway[jj] != last) {
                    last = highway[jj];
                    dist = Math.min((jj - ii), dist);
                    ii = jj;
               } else if (highway[jj] == last) {
                    ii = jj;
                }
            }

            System.out.println(dist);
        }
    }
}
