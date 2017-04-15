/**
 * 
 */
package _2_2_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author willsaibott
 *
 */
public class ex6
{

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    List<Integer> list = new ArrayList<>();
    Random randomGenerator = new Random();
    for (int i = 0; i < 100; i++)
      list.add(randomGenerator.nextInt(101));
    Collections.sort(list);
    
    System.out.println("Input: ");
    for (Integer i: list)
      System.out.print(i + ", ");
    
    System.out.println("\nOutput: " + list.get(49));
  }
}
