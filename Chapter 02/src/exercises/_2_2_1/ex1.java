/**
 *
 */
package _2_2_1;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author gbordignon
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
    List<Integer> list = new ArrayList<Integer>();
    Random randomGenerator = new Random();
    int cont = - 1;
    for (int i = 0; i < 30; i++)
      list.add(randomGenerator.nextInt(101) - 50);

    Collections.sort(list);
    int prev = list.get(0);
    System.out.println("Input:");
    for (Integer i:list)
    {
      System.out.print(" " + i);
      if (i == prev)
        cont++;
      prev = i;
    }
    System.out.println("\nRepetitions: " + cont + " pair(s)");
  }
}