package com.wip._2._3;

import static com.wip.Utils.defineInputMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * This is a wrapper for the submition class. In order to submit it in uva judge platform,
 * copy just the class Main and the necessary imports.
 */
public class UVA11629 {

    final static String packName = UVA11629.class.getPackage().getName();
    final static String chapter = packName.substring(packName.indexOf("wip._") + 5).replace("_", "");

    public static void main(String[] args) throws IOException {
        defineInputMethod(UVA11629.class, chapter);
        Main11629.main(args);
    }
}


/**
 * This Class may not be most optimized as it could be, but I try to
 * keep code organization and optimizations balanced the most I can.
 */
class Main11629 {

    private static class Party {
        String name;
        double votesPerCent;

        public Party(String name, double votesPerCent) {
            this.name = name;
            this.votesPerCent = votesPerCent;
        }

        public String getName() {
            return name;
        }

        public double getVotesPerCent() {
            return votesPerCent;
        }
    }

    private static class Guess {
        public List<Party> parties = new ArrayList<>();
        private String operator = "";
        private Integer guess;

        public void setOperator(String operator) {
            this.operator = operator;
        }

        public void setGuess(Integer guess) {
            this.guess = guess;
        }

        public Guess linkTo(Party party) {
            if (party!=null) {
                parties.add(party);
            }
            return this;
        }

        public boolean is_correct() {
            double sum = 0.0;
            for (Party party :  parties) {
                sum += party.getVotesPerCent();
            }
            sum = Math.round(sum*10.0)/10.0;
            switch (operator) {
                case ">=": return sum >= guess;
                case "<=": return sum <= guess;
                case "<":  return sum < guess;
                case ">":  return sum > guess;
                case "=":  return sum == guess;
                default:   return false;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<String, Party> parties = new TreeMap<>();
        String line[] = bf.readLine().split("\\s");
        int number_of_parties = Integer.parseInt(line[0]);
        int number_of_guesses = Integer.parseInt(line[1]);

        for (int ii = 0; ii < number_of_parties; ii++) {
            String party[] = bf.readLine().split("\\s");
            parties.put(party[0], new Party(party[0], Double.parseDouble(party[1])));
        }

        for (int ii = 0; ii < number_of_guesses; ii++) {
            String guess_line[] = bf.readLine().split("\\s");
            Guess guess = new Guess();

            for (int jj = 0; jj < (guess_line.length - 2); jj++) {
                guess.linkTo(parties.get(guess_line[jj]));
            }

            guess.setOperator(guess_line[guess_line.length - 2]);
            guess.setGuess(Integer.parseInt(guess_line[guess_line.length - 1]));

            sb.append("Guess #").append(ii+1);
            if (guess.is_correct()) {
                sb.append(" was correct.\n");
            }
            else {
                sb.append(" was incorrect.\n");
            }
        }

        System.out.write(sb.toString().getBytes());
    }
}
