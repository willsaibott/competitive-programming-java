import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main
{

  private final static int MAX_GROUPS = 20;

  private static double[][] dist = new double[MAX_GROUPS][MAX_GROUPS];
  private static double[] memo = new double[1 << 16];
  private static int N, target;
  private static double[] x = new double[MAX_GROUPS];
  private static double[] y = new double[MAX_GROUPS];
  private static int size;

  public static void main(String[] args) throws FileNotFoundException {
    Scanner scanner;
    int caseNo = 1;

    if (args.length > 0)
      scanner = new Scanner(new File(args[0]));
    else
      scanner = new Scanner(System.in);

    while ((N = scanner.nextInt()) > 0){
      size = 2 * N;
      for (int i = 0; i < size; i++) {
        String skip = scanner.next();
        x[i] = scanner.nextDouble();
        y[i] = scanner.nextDouble();
      }

      for (int i = 0; i < size - 1; i++) {
        for (int j = i + 1; j < size; j++) {
          dist[i][j] = dist[j][i] = Math.hypot(x[i] - x[j], y[i] - y[j]);
        }
      }

      target = (1 << size) - 1;
      for (int i = 0; i < (1 << 16); i++) {
        memo[i] = -1.0;
      }

      System.out.printf("Case %d: %.2f\n", caseNo++, matching(0));
    }

    scanner.close();
  }

  public static double matching(int bitmask) {
    if (memo[bitmask] > - 0.5) {
      return memo[bitmask];
    } else if (bitmask == target) {
      return memo[bitmask] = 0;
    }

    double ans = 2E9;

    int p1, p2;

    for (p1 = 0; p1 < size && ((bitmask & (1 << p1)) != 0); p1++);

    for (p2 = p1 + 1; p2 < size; p2++) {
      if ((bitmask & (1 << p2)) == 0) {
        ans = Math.min(ans,
                       dist[p1][p2] + matching(bitmask | (1 << p1) | (1 << p2)));
      }
    }

    return memo[bitmask] = ans;
  }
}