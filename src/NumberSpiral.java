import java.util.Arrays;
import java.util.Scanner;

/**
 * https://cses.fi/problemset/task/1071
 *
 * A number spiral is an infinite grid whose upper-left square has number 1.
 * Here are the first five layers of the spiral:
 *
 *                            1   2   9  10  25
 *                            4   3   8  11  24
 *                            5   6   7  12  23
 *                           16  15  14  13  22
 *                           17  18  19  20  21
 *
 * Your task is to find out the number in row y and column x.
 *
 * Input
 *
 * The first input line contains an integer t: the number of tests.
 *
 * After this, there are t lines, each containing integers y and x.
 *
 * Output
 *
 * For each test, print the number in row y and column x.
 *
 * Constraints
 * 1≤t≤10^5
 * 1≤y,x≤10^9
 * Example
 *
 * Input:
 * 3
 * 2 3
 * 1 1
 * 4 2
 *
 * Output:
 * 8
 * 1
 * 15
 */
public class NumberSpiral {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = Integer.parseInt(sc.nextLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < t; i++) {
      String[] line = sc.nextLine().split(" ");
      long[] a = Arrays.stream(line).mapToLong(Long::parseLong).toArray();
      sb.append(algorithm(a));
      if(i < t-1) {
        sb.append(System.lineSeparator());
      }
    }
    System.out.println(sb.toString());
    sc.close();
  }

  public static long algorithm(long[] a) {
    long res;
    long x = a[1]; // column
    long y = a[0]; // row
    if(x >= y) {
      if(x%2 == 0) {
        x--;
        res = (x*x + y);
      } else {
        res = x*x - y + 1;
      }
    } else {
      if(y%2 == 0) {
        res = y*y - x + 1;
      } else {
        y--;
        res = y*y + x;
      }
    }
    return res;
  }
}
