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
public class ex2
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
      String str = (isOdd(n))? "odd\n": "even\n";
      System.out.printf("%3d is " + str, n);
    }
    scanner.close();
  }

  private static boolean isOdd(int n)
  {
    return ((n & 1) == 0);
  }
}
