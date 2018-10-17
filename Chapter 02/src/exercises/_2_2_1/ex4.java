/**
 * 
 */
package _2_2_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @author willsaibott
 *
 */
public class ex4
{

  /**
   * @param args
   * @throws FileNotFoundException 
   */
  public static void main(String[] args) throws FileNotFoundException
  {
    Scanner scanner = new Scanner(new File(args[0]));
    int a, b;
    List<Integer> list = new ArrayList<Integer>();
    Random randomGenerator = new Random();
    System.out.println("Input: ");
    for (int i = 0; i < 100; i++)
    {
      list.add(randomGenerator.nextInt(101));
    }
    Collections.sort(list);

    for (Integer i: list)
      System.out.print(i + ", ");

    while (scanner.hasNext())
    {
      a = scanner.nextInt();
      b = scanner.nextInt();
      System.out.println("a=" + a + ", b=" + b);
      for (Integer i: list)
      {
        if (i >= a && i <= b)
          System.out.print(i + ", ");
      }
      System.out.println();
    }
    scanner.close();
  }
}
