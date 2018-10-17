/**
*
*/
package _2_2_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

/**
* @author gbordignon
*
*/
public class ex2
{

 /**
  * @param args
  * @throws FileNotFoundException
  */
 public static void main(String[] args) throws FileNotFoundException
 {
   Scanner scanner = new Scanner(new File(args[0]));
   HashSet<Integer> hash = new HashSet<Integer>();
   int[] array = new int[30];
   Random randomGenerator = new Random();

   for (int i = 0; i < 30; i++)
     array[i] = (randomGenerator.nextInt(101) - 50);

   System.out.println("Input:");
   for (int i : array)
   {
     System.out.print(" " + i);
   }

   while (scanner.hasNext())
   {
     int v = scanner.nextInt();
     System.out.println("\nInput: " + v);
     for (int i : array)
     {
       if (!hash.contains(i) && hash.contains(v - i))
       {
         System.out.println("Pair: " + i + ", " + (v - i));
       }
       hash.add(i);
     }
     hash.clear();
   }
   scanner.close();
 }
}
