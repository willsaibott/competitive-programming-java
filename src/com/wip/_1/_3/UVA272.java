package com.wip._1._3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class UVA272 {
    public static void main(String[] args) {
        defineInputMethod(args);
        boolean first = true;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            StringBuilder sbuilder = new StringBuilder();
            String line = scanner.nextLine();

            for (int ii = 0; ii < line.length(); ii++) {
                char c = line.charAt(ii);
                if (c == '\"') {
                    if (first)
                        sbuilder.append("``");
                    else
                        sbuilder.append("''");
                    first = !first;
                } else {
                    sbuilder.append(c);
                }
            }

            System.out.println(sbuilder.toString());
        }
    }

    public static void defineInputMethod(String[] args) {
        if(args.length > 0) {
            try {
                String current = new java.io.File( "." ).getCanonicalPath();
                System.out.println("Current dir:"+current);
                System.setIn(new FileInputStream(args[0]));

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
