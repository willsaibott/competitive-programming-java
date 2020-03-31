package com.wip._2._3;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;


/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA11572 {

    final static String packName = UVA11572.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA11572.class, chapter);
        Main.main(args);
    }

    /**
     * This Class may not be most optimized as it could be, but I try to
     * keep code organization and optimizations balanced the most I can.
     */
    static class Main {

        private static class Solution {
            List<Integer> snowFlakes;

            public Solution(Integer number_of_snow_flakes) {
                snowFlakes = new ArrayList<>(number_of_snow_flakes);
            }

            public void add(Integer snowFlakeId) {
                snowFlakes.add(snowFlakeId);
            }

            public void solve(StringBuilder sb) {
                Map<Integer, Integer>  snowFlakesSequence = new HashMap<>(snowFlakes.size());
                Integer max = 0, begin = 0, current = 0;

                for (int ii = 0; ii < snowFlakes.size(); ii++) {
                    Integer snow_flake_id     = snowFlakes.get(ii);
                    Integer index_of_repeated = snowFlakesSequence.getOrDefault(snow_flake_id, -1);

                    if (index_of_repeated >= 0) {
                        // This is not a unique sequence anymore.
                        // Found a repeated value, move the begin indicator until the position of the rep
                        while (begin <= index_of_repeated) {
                            snowFlakesSequence.remove(snowFlakes.get(begin));
                            begin++;
                        }
                    }

                    snowFlakesSequence.put(snow_flake_id, ii);
                    current = snowFlakesSequence.size();

                    if (current > max) {
                        max = current;
                    }
                }

                sb.append(max).append("\n");
            }
        }

        public static void main(String[] args) throws IOException {

            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            Scanner scanner   = new Scanner(System.in);
            StringBuilder sb = new StringBuilder();

            int k = 0;
            int testCases = scanner.nextInt();
            while (k++ < testCases) {
                int number_of_snow_flakes = scanner.nextInt();
                Solution solution         = new Solution(number_of_snow_flakes);
                for (int jj = 0; jj < number_of_snow_flakes; jj++) {
                    solution.add(scanner.nextInt());
                }
                solution.solve(sb);
            }

            System.out.write(sb.toString().getBytes());
        }
    }
}



