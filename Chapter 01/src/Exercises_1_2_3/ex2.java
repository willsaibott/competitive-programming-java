package Exercises_1_2_3;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 *
 * @author gbordignon
 * @throws FileNotFoundException  if Scanner does not find the input file
 */
public class ex2 {

  public static void main(String[] args) throws FileNotFoundException {
    Scanner scanner = new Scanner(new File(args[0]));
    double pi = Math.PI;
    int places;
    while(scanner.hasNext())
    {
      places = scanner.nextInt();
      if (places == 0) continue;
      double pi2 = BigDecimal.valueOf(pi)
                     .setScale(places, RoundingMode.HALF_UP)
                     .doubleValue();
      System.out.println("Places=" + String.valueOf(places) + "\tPI=" + String.valueOf(pi2));
    }
    scanner.close();
  }
}
