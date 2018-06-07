package com.wip._1._3;

import java.util.HashMap;
import java.util.Scanner;

import static com.wip.Utils.defineInputMethod;

/**
 * In order to submit it in uva judge platform, remove the public modifier from the
 * class declaration, rename the class to Main and remove the package declaration
 */
public class UVA11507 {

    public static void main(String[] args) {
        defineInputMethod(UVA11507.class);

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int length = Integer.parseInt(scanner.nextLine().trim());
            if (length <= 0) break;

            String[] rotations = scanner.nextLine().split(" ");
            String output = "+x";

            for (String rotation : rotations) {
                if (!rotation.equals("No")) {
                    String outputInv = (output.charAt(0) == '-' ? "+" + output.charAt(1) : "-" + output.charAt(1));
                    String rotationInv = (rotation.charAt(0) == '-' ? "+" + rotation.charAt(1) : "-" + rotation.charAt(1));

                    if (output.equals("+x")) {
                        output = rotation;
                    } else if (output.equals("-x")) {
                        output = rotationInv;
                    } else if (rotation.equals(output)) {
                        output = "-x";
                    } else if (rotation.equals(outputInv)) {
                        output = "+x";
                    }
                }
            }

            System.out.println(output);
        }
    }

// Second solution:
//    public static void main(String[] args) {
//        defineInputMethod(UVA11507.class);
//
//        Scanner scanner = new Scanner(System.in);
//        HashMap<String, String> map = getTruthTable();
//
//        while (scanner.hasNext()) {
//            int length = Integer.parseInt(scanner.nextLine().trim());
//            if (length <= 0) break;
//
//            String[] rotations = scanner.nextLine().split(" ");
//            String output = "+x";
//
//            for (String rotation : rotations){
//                if (!rotation.equals("No")) {
//                    output = map.get(output + rotation);
//                }
//            }
//
//            System.out.println(output);
//        }
//    }
//
//    private static HashMap<String,String> getTruthTable() {
//        HashMap<String, String> map = new HashMap<>();
//
//        map.put("+x+y", "+y");
//        map.put("+x+z", "+z");
//        map.put("+x-y", "-y");
//        map.put("+x-z", "-z");
//        map.put("-x+y", "-y");
//        map.put("-x+z", "-z");
//        map.put("-x-y", "+y");
//        map.put("-x-z", "+z");
//
//        map.put("+y+y", "-x");
//        map.put("+y+z", "+y");
//        map.put("+y-y", "+x");
//        map.put("+y-z", "+y");
//        map.put("-y+y", "+x");
//        map.put("-y+z", "-y");
//        map.put("-y-y", "-x");
//        map.put("-y-z", "-y");
//
//        map.put("+z+y", "+z");
//        map.put("+z+z", "-x");
//        map.put("+z-y", "+z");
//        map.put("+z-z", "+x");
//        map.put("-z+y", "-z");
//        map.put("-z+z", "+x");
//        map.put("-z-y", "-z");
//        map.put("-z-z", "-x");
//
//        return map;
//    }
}
