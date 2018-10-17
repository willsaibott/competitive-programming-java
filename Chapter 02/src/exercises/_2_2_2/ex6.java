/**
 * 
 */
package _2_2_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author willsaibott
 *
 */
public class ex6
{

  /**
   * @param args
   * @throws FileNotFoundException 
   */
  public static void main(String[] args) throws FileNotFoundException
  {
    Scanner scanner = new Scanner(new File(args[0]));
    
    while (scanner.hasNext())
    {
      int n = scanner.nextInt();
      int mask = n - 1;
      int prod = n | mask;
      System.out.println(Integer.toBinaryString(n) +
                         " with the last consecutives zeros is " +
                         Integer.toBinaryString(prod));
    }
    scanner.close();
  }
}
