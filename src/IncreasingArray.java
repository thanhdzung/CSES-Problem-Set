import java.util.Arrays;
import java.util.Scanner;

/**
 * https://cses.fi/problemset/task/1094
 *
 * Time limit: 1.00 s Memory limit: 512 MB
 * You are given an array of n integers. You want to modify the array so that it is increasing, i.e., every element is at least as large as the previous element.
 *
 * On each turn, you may increase the value of any element by one. What is the minimum number of turns required?
 *
 * Input
 *
 * The first input line contains an integer n: the size of the array.
 *
 * Then, the second line contains n integers x1,x2,…,xn: the contents of the array.
 *
 * Output
 *
 * Print the minimum number of turns.
 *
 * Constraints
 * 1≤n≤2*10^5
 * 1≤xi≤10^9
 * Example
 *
 * Input:
 * 5
 * 3 2 5 1 7
 *
 * Output:
 * 5
 */
public class IncreasingArray {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.nextLine());
    String[] line = sc.nextLine().split(" ");
    long[] a = Arrays.stream(line).mapToLong(Long::parseLong).toArray();
    sc.close();
    System.out.print(algorithm(a));
  }

  public static long algorithm(long[] a) {
    long noOfTurn = 0;
    long prev = a[0];
    for (int i=1; i < a.length; i++) {
      if(a[i] < prev) {
        noOfTurn += prev - a[i];
      } else {
        prev = a[i];
      }
    }
    return noOfTurn;
  }
}
