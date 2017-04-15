package Exercises_1_2_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class ex1
{

  /**
   * @param args
   * @throws FileNotFoundException 
   */
  public static void main(String[] args) throws FileNotFoundException
  {
    Scanner scanner = new Scanner(new File(args[0]));
    double in;
    scanner.useLocale(Locale.US);
    while (scanner.hasNext())
    {
      in = scanner.nextDouble();
      System.out.printf("%7.3f\n", in); 
    }
    scanner.close();
  }
}
