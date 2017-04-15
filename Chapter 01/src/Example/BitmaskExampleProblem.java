package Example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BitmaskExampleProblem
{

  public final static int MAX_SIZE = 20; 
  private static int N;
  private static int size;
  private static int target = 0;
  private static double [] memo = new double[1 << 16];
  private static double [] dist[] = new double[MAX_SIZE][MAX_SIZE];
  private static int [] x = new int[MAX_SIZE];
  private static int [] y = new int[MAX_SIZE];
  
  /**
   * @param args
   * @throws FileNotFoundException 
   */
  public static void main(String[] args) throws FileNotFoundException
  {
    Scanner scanner;
    if (args.length > 0)
      scanner = new Scanner(new File(args[0]));
    else
      scanner = new Scanner(System.in);
        
    N = scanner.nextInt();
    if (N <= 0 && N > MAX_SIZE)
    {
      scanner.close();
      return;
    }
    
    size = 2 * N;
    
    for (int i = 0; i < size; i++)
    {
      x[i] = scanner.nextInt();
      y[i] = scanner.nextInt();
    }
    
    for (int i = 0; i < size - 1; i++)
      for (int j = i + 1; j < size; j++)
        dist[i][j] = dist[j][i] = Math.hypot(x[i] - x[j], y[i] - y[j]);
        
    for (int i = 0; i < (1 << 16); i++) memo[i] = - 1.0f;
    
    target = (1 << size) - 1;
    System.out.println(matching(0));
    scanner.close();
  }

  private static double matching(int bitmask)
  {
    double ans = 2E9;
    int p1, p2;
    if (memo[bitmask] > - 0.5f) return memo[bitmask];
    if (bitmask == target) return (memo[bitmask] = 0);
    
    for (p1 = 0; (p1 < size) && ((bitmask & (1 << p1)) != 0); p1++);
    for (p2 = p1 + 1; (p2 < size); p2++)
      if ((bitmask & (1 << p2)) == 0)
      {
        ans = Math.min(ans, dist[p1][p2] + matching((bitmask | (1 << p1) | (1 << p2))));
      }
    
    return (memo[bitmask] = ans);
  }

}
