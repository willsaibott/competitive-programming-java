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

public class GrayCode {

  // append reverse of order n gray code to prefix string, and print
  public static void yarg(String prefix, int n) {
    if (n == 0) System.out.println(prefix);
    else {
      gray(prefix + "1", n - 1);
      yarg(prefix + "0", n - 1);
    }
  }  
  // append order n gray code to end of prefix string, and print
  public static void gray(String prefix, int n) {
    if (n == 0) System.out.println(prefix);
    else {
      gray(prefix + "0", n - 1);
      yarg(prefix + "1", n - 1);
    }
  }  
  public static void main(String[] args) throws FileNotFoundException {
    Scanner scanner = new Scanner(new File(args[0]));

    while(scanner.hasNext())
    {
      int n = scanner.nextInt();
      System.out.println("N-bits=" + n);
      gray("", n);
    }
    scanner.close();
  }
}