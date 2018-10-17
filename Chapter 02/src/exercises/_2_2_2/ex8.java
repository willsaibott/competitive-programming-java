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
public class ex8
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
      int grey = scanner.nextInt();
      int n = decodeGrey(grey);
      System.out.println(n);
    }
    scanner.close();
  }

  private static int decodeGrey(int grey)
  {
    int value = 0;
    while (grey != 0)
    {
      value = value ^ grey;
      grey >>>= 1;
    }
    return value;
  }
}
