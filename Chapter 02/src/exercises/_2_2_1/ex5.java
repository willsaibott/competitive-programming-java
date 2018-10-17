/**
 * 
 */
package _2_2_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @author willsaibott
 *
 */
public class ex5
{

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    Random randomGenerator = new Random();
    List<Integer> list = new ArrayList<Integer>();
    HashMap<Integer, List<Integer>> hash = new HashMap<>();
    for (int i = 0; i < 100; i++)
      list.add(randomGenerator.nextInt(101));
    Collections.sort(list);
    
    System.out.println("Input: ");
    int prev = - 2;
    int cont = 0;
    int max = 0;
    int maxHashIndex = 0;
    int index = 0;
    List<Integer> subArray = new ArrayList<>();
    for (Integer i: list)
    {
      System.out.print(i + ", ");
      if (prev == ( i - 1))
      {
        cont++;
        subArray.add(i);
      }
      else
      {
        if (max < cont)
        {
          maxHashIndex = index;
          max = cont;
        }
        hash.put(index++, new ArrayList<Integer>(subArray));
        cont = 0;
        subArray.clear();
      }
      prev = i;
    }
    System.out.println("\nMax Length sub-array: " + max + "\nSub Array: ");
    for (Integer i:hash.get(maxHashIndex))
    {
      System.out.print(i + ", ");
    }
  }
}
