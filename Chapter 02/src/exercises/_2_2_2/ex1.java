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
public class ex1
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
      int s = scanner.nextInt();
      int n = scanner.nextInt();
      System.out.println("Mod of " + s + " by " + n + " is " + mod(s, n));
    }
    scanner.close();
  }
  
  public static int mod(int s, int n)
  {
    return (s & (n - 1));
  }
}
