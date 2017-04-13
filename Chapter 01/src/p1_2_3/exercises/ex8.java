/**
 *
 */
package p1_2_3.exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author gbordignon
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
    int[] numbers = new int[100];
    for (int i = 0; i < 100; i++)
      numbers[i] = i;
    while(scanner.hasNext())
    {
      int n = scanner.nextInt();
      System.out.println("Input: " + n);
      Subset.print(numbers, n);
    }
    scanner.close();
  }

  public static class Subset
  {

    public static void print(int[] numbers, int n)
    {
      int target = (int) (Math.pow(2, n) - 1);
      int bitmask = 0;

    }
  }
}
