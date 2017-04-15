/**
 *
 */
package Exercises_1_2_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author gbordignon
 *
 */
public class ex8
{

  private static int subsetNumber = 0;
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
      System.out.println("\nInput: " + n);
      Subset.print(numbers, n);
    }
    scanner.close();
  }

  public static class Subset
  {

    public static void print(int[] numbers, int n)
    {
      int target = (int) ((1 << n) - 1);
      int bitmask = 0;
      subsetNumber = 0;
      while (bitmask <= target)
      {
        //System.out.println("Subset of " + bitmask + ":");
        System.out.print("\n" + ++subsetNumber + ": ");
        for (int i = 0; i < n; i++)
        {
          if (((1 << i) & bitmask) != 0)
          {
            System.out.print(numbers[i]);
          }
        }
        bitmask++;
      }
    }
  }
}
