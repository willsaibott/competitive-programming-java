/**
 *
 */
package Exercises_1_2_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author gbordignon
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
    List<Integer> list = new ArrayList<Integer>();
    Scanner scanner = new Scanner(new File(args[0]));
    while (scanner.hasNext())
      list.add(scanner.nextInt());
    scanner.close();

    Collections.sort(list, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2)
      {
        return (o1 - o2);
      }
    });

    Integer prev = 0, count = 0;
    for (Integer i : list)
    {
      if ((count++ == 0) || (i.compareTo(prev) != 0))
        System.out.println(i);
      prev = i;
    }
  }
}
