/**
 * 
 */
package Exercises_1_2_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author willsaibott
 *
 */
public class ex10
{

  /**
   * @param args
   * @throws FileNotFoundException 
   */
  public static void main(String[] args) throws FileNotFoundException
  {
    Scanner scanner = new Scanner(new File(args[0]));
    String replacement = " *** ";
    String regex = " [a - z]\\d{2} ";
    while (scanner.hasNext())
    {
      String line = scanner.nextLine();
      System.out.println(line.replaceAll(regex, replacement));
    }
    scanner.close();
  }

}
