/**
 * 
 */
package _1_2_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @author willsaibott
 *
 */
public class ex6
{
  static int comparisons = 0;
  /**
   * @param args
   * @throws FileNotFoundException 
   */
  public static void main(String[] args) throws FileNotFoundException
  {
    Scanner scanner = new Scanner (new File(args[0]));
    List<Integer> list = new ArrayList<Integer>();
    for (int i = 0; i < (1E6); i++)
      list.add(randomFill(100));
    
    list.sort(new Comparator<Integer>(){
      @Override
      public int compare(Integer o1, Integer o2)
      {
        return o1 - o2;
      }
    });
    
    while(scanner.hasNext())
    {
      int key = scanner.nextInt();
      int pos = binarySearch(list, key, new Comparator<Integer>(){
        @Override
        public int compare(Integer o1, Integer o2)
        {
          comparisons++;
          return o1 - o2;
        }
      });
      if (pos >= 0)
        System.out.println(key + " found at: " + pos + " after " + comparisons + " comparisons.");
      else
        System.out.println(key + " not found after " + comparisons + " comparisons.");
      comparisons = 0;
      int pos2 = Collections.binarySearch(list, key, new Comparator<Integer>(){
        @Override
        public int compare(Integer o1, Integer o2)
        {
          comparisons++;
          return o1 - o2;
        }
      });
      if (pos2 >= 0)
        System.out.println(key + " found at: " + pos2 + " after " + comparisons + " comparisons.");
      else
        System.out.println(key + " not found after " + comparisons + " comparisons.");
      comparisons = 0;
    }
    scanner.close();
  }

  private static int randomFill(int bound)
  {
    Random rand = new Random();
    return rand.nextInt(bound);
  }
  
  private static int binarySearch(List<Integer> list, Integer key, Comparator<Integer> comparator){
    int pos = list.size() / 2;
    int begin = 0, end = list.size() - 1;
    int diff = comparator.compare(list.get(pos), key);
    
    while((diff != 0))
    {
      if (diff > 0)
      {
        end = pos - 1;
        pos = (begin + end) / 2;
        diff = comparator.compare(list.get(pos), key);
      }
      else
      {
        begin = pos + 1;
        pos = (begin + end) / 2;
        diff = comparator.compare(list.get(pos), key);
      }
      if (end < begin)
        return -1;
    }
    return pos;
  }

}
