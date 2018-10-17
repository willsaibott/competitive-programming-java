package com.wip._1._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static com.wip.Utils.defineInputMethod;

/**
 * In order to submit it in uva judge platform, remove the public modifier from the
 * class declaration, rename the class to Main and remove the package declaration
 */
public class UVA11683 {
    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA11683.class);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String a;
        while ((a = bf.readLine()) != null  && !a.equals("0") && !a.equals("0 0")) {
            StringTokenizer tokenizer = new StringTokenizer(a);
            int height = Integer.parseInt(tokenizer.nextToken());
            int length = Integer.parseInt(tokenizer.nextToken());
            int[] form = new int[length];
            int on = 0;

            tokenizer = new StringTokenizer(bf.readLine());
            on =  height - (form[0] = Integer.parseInt(tokenizer.nextToken()));

            for (int ii = 1; ii < length; ii++) {
                form[ii] = Integer.parseInt(tokenizer.nextToken());

                if (form[ii] < form[ii - 1]) {
                    on += form[ii - 1] - form[ii];
                }
            }

            System.out.println(on);
        }
    }
}
