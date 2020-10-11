import java.util.Scanner;

/**
 * https://cses.fi/problemset/task/1070
 *
 * A permutation of integers 1,2,…,n is called beautiful if there are no adjacent elements whose difference is 1.
 *
 * Given n, construct a beautiful permutation if such a permutation exists.
 *
 * Input
 *
 * The only input line contains an integer n.
 *
 * Output
 *
 * Print a beautiful permutation of integers 1,2,…,n. If there are several solutions, you may print any of them. If there are no solutions, print "NO SOLUTION".
 *
 * Constraints
 * 1≤n≤10^6
 * Example 1
 *
 * Input:
 * 5
 *
 * Output:
 * 4 2 5 3 1
 *
 * Example 2
 *
 * Input:
 * 3
 *
 * Output:
 * NO SOLUTION
 */
public class Permutations {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.print(algorithm(n));
  }

  /**
   * if n = 1 then print '1'
   * if n = 2 or n = 3 then print 'NO SOLUTION'
   * if n > 3 Print a list of even numbers in ascending order first,
   * then print a list of odd numbers in ascending order later
   * @param n
   */
  public static String algorithm(int n) {
    if(n == 1) {
      return "1";
    } else if(n == 2 || n == 3) {
      return "NO SOLUTION";
    } else {
      StringBuilder evens = new StringBuilder();
      StringBuilder odds = new StringBuilder();
      for (int i = 1; i <= n; i++) {
        if(i%2 == 0) {
          evens.append(i);
          evens.append(" ");
        } else {
          odds.append(i);
          // i is not a last odd number of list
          if(i != n && i != n-1) {
            odds.append(" ");
          }
        }
      }
      return evens.append(odds).toString();
    }
  }
}
