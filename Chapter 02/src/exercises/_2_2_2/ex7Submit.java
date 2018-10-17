package _2_2_2;
import java.util.Scanner;

/**
 * @author willsaibott
 *
 */
class ex7Submit
{

  /**
   * @param args 
   */
  public static void main(String[] args)
  {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int[] n = new int[N];
    int[] k = new int[N];
    for (int i = 0; i < N; i++)
    {
      n[i] = scanner.nextInt();
      k[i] = scanner.nextInt();
    }
    for (int i = 0; i < N; i++)
      System.out.printf("%d\n", k[i] ^ (k[i] >> 1));
    scanner.close();
  }
}
