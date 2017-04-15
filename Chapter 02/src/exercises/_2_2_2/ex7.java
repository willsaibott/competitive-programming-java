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
public class ex7
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
      int k = scanner.nextInt();
      //System.out.println(Integer.toBinaryString(k ^ (k >> 1)) +
      //                   "=" + (k ^ (k >> 1)));
      System.out.printf("%d\n", k ^ (k >> 1));
    }
    scanner.close();
  }
}
