package com.wip._2._3;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.*;

/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA11348 {

    final static String packName = UVA11348.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA11348.class, chapter);
        MainUVA11348.main(args);
    }
}

class Owner implements Comparable<Owner> {
    public  Set<Stamp> stamps = new TreeSet<>();
    private int        unique_keys     = 0;
    private int        id = 0;
    private static int total_unique_keys = 0;
    private static int total_instances = 0;

    public Owner() {
        id = total_instances++;
    }

    private void addUniqueKey() {
        unique_keys++;
        total_unique_keys++;
    }

    public void compute() {
        for (Stamp stamp : stamps) {
            if (stamp.owners.size() == 1) {
                addUniqueKey();
            }
        }
    }

    public int getUniqueKeys() {
        return unique_keys;
    }

    public double getFractionIncome() {
        return (double) unique_keys / (double) total_unique_keys;
    }

    public static int getTotalUniqueKeys() {
        return total_unique_keys;
    }

    @Override
    public int compareTo(Owner o) {
        return id - o.id;
    }

    @Override
    public String toString() {
        return "Owner{" +  "id=" + id +  '}';
    }

    public static void clear () {
        total_unique_keys = 0;
        total_instances = 0;
    }
}

class Stamp implements Comparable<Stamp> {
    public Set<Owner> owners = new TreeSet<>();
    public int id;

    public Stamp(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Stamp{" +  "id=" + id +  '}';
    }

    @Override
    public int compareTo(Stamp o) {
        return id - o.id;
    }
}

class Solution {

    Map<Integer, Stamp> stamps        = new HashMap<>();
    List<Owner>         owners        = new ArrayList<>();
    DecimalFormat       decimalFormat = new DecimalFormat(" 0.000000%");

    public
    Solution() { }

    public Owner
    new_owner() {
        owners.add(new Owner());
        return owners.get(owners.size()-1);
    }

    public void
    add_stamp(Owner owner, int stamp_id) {
        Stamp stamp = null;
        if (stamps.containsKey(stamp_id)) {
            stamp = stamps.get(stamp_id);
        }
        else {
            stamps.put(stamp_id, stamp = new Stamp(stamp_id));
        }
        stamp.owners.add(owner);
        owner.stamps.add(stamp);
    }

    public void
    solve (StringBuilder sb) {
        for (Owner owner : owners) {
            owner.compute();
        }
        if (Owner.getTotalUniqueKeys() > 0) {
            for (Owner owner : owners) {
                sb.append(decimalFormat.format(owner.getFractionIncome()));
            }
            sb.append("\n");
        }
        else {
            sb.append(" \n");
        }
        Owner.clear();
    }
}


/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class MainUVA11348 {

    public static void main(String[] args) throws IOException {

//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);

        int k = 0;
        final int testCases = scanner.nextInt();
        while (k++ < testCases) {
            Solution solution = new Solution();

            final int number_of_owners = scanner.nextInt();
            for (int ii = 0; ii < number_of_owners; ii++) {
                Owner owner = solution.new_owner();

                final int number_of_stamps = scanner.nextInt();
                for (int jj = 0; jj < number_of_stamps; jj++) {
                    solution.add_stamp(owner, scanner.nextInt());
                }
            }

            solution.solve(sb.append("Case ").append(k).append(":"));
        }

        System.out.write(sb.toString().getBytes());
    }
}
