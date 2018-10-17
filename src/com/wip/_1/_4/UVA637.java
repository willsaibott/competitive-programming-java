package com.wip._1._4;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main637 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String line;
        boolean begin = true;

        while ((line = bf.readLine()) != null && !line.equals("0")) {
            int pages = Integer.parseInt(line);
            int start = 1, end = pages;
            int sheet = 1;

            if (pages > 1) {
                end += ((pages & 0b0011) > 0 ? 4 - (pages & 0b0011) : 0);
            }
            else
            {
                end = 2;
            }


            sb.append("Printing order for ")
              .append(pages)
              .append(" pages:\n");


            while (start < end)
            {
                sb.append("Sheet ")
                  .append(sheet)
                  .append(", front: ")
                  .append((end > pages) ? "Blank" : end)
                  .append(", ")
                  .append(start)
                  .append("\n");

                end--;
                start++;

                if (start >= end) break;

                sb.append("Sheet ")
                  .append(sheet)
                  .append(", back : ")
                  .append(start)
                  .append(", ")
                  .append((end > pages) ? "Blank" : end)
                  .append("\n");

                end--;
                start++;
                sheet++;
            }
        }

        System.out.write(sb.toString().getBytes());
    }
}

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA637 {

    final static String packName = UVA637.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA637.class, chapter);
        Main637.main(args);
    }
}
