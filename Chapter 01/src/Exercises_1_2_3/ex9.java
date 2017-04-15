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
public class ex9
{

  /**
   * @param args
   * @throws FileNotFoundException 
   */
  public static void main(String[] args) throws FileNotFoundException
  {
    Scanner scanner = new Scanner(new File(args[0]));
    String number;
    int x, y;
    while (scanner.hasNext())
    {
      number = scanner.next();
      x = scanner.nextInt();
      y = scanner.nextInt();
      System.out.println("\nInput: "+ number + " in base " + x + " to base " + y +
                         "\nJava version: " + 
                         Long.toString(Integer.parseInt(number, x), y));
      System.out.println("My version: " + Base.convert(number, x, y));
    }
    scanner.close();
  }
  
  public static class Base
  {
    public static String convert(String n, int base1, int base2)
    {
      int number = Integer.parseInt(n, base1);
      int rest;
      StringBuilder sb = new StringBuilder();
      while (number > 0)
      {
        rest = number % base2;
        number /= base2;
        sb.append(valueToBase(rest));
      }
      return sb.reverse().toString();
    }

    private static String valueToBase(int rest)
    {
      return ((rest > 9)? 
               String.valueOf((char)(rest - 10 + 'a')):
               String.valueOf(rest));
    }
  }
}
