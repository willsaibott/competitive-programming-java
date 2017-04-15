/**
 *
 */
package _1_2_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author gbordignon
 *
 */
public class ex7
{

  private static int permutation = 0;
  /**
   * @param args
   * @throws FileNotFoundException
   */
  public static void main(String[] args) throws FileNotFoundException
  {
    Scanner scanner = new Scanner(new File(args[0]));
    int i = 0, nPerm;
    char[] letterArray = new char[26];
    for (char c = 'a'; c <= 'z'; c++)
      letterArray[i++] = c;

    while (scanner.hasNext())
    {
      nPerm = scanner.nextInt();
      Permutation.print(letterArray, nPerm);
      permutation = 0;
    }
    scanner.close();
  }

  public static class Permutation
  {
    static void print(char[] letterArray, int nPerm)
    {
      System.out.println("Permutation of " + nPerm + " elements:" );
      permute(new String(letterArray), 0, nPerm - 1, nPerm);
    }

    private static void permute(String letterArray,
                                int begin,
                                int end,
                                int nPerm)
    {

      if (begin == end)
        System.out.println(letterArray.substring(0, nPerm) + " " + (++permutation));
      else
      {
        for (int i = begin; i <= end; i++)
        {
          letterArray = swap(letterArray, begin, i);
          permute(letterArray, begin + 1, end, nPerm);
          letterArray = swap(letterArray, begin, i);
        }
      }
    }

    private static String swap(String letterArray, int i, int j)
    {
      StringBuilder sb = new StringBuilder(letterArray);
      char temp = sb.charAt(i);
      sb.setCharAt(i, sb.charAt(j));
      sb.setCharAt(j, temp);
      return sb.toString();
    }
  }
}
