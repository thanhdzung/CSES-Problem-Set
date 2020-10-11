import java.util.Arrays;
import java.util.Scanner;

/**
 * https://cses.fi/problemset/task/1083/
 * You are given all numbers between 1,2,…,n except one. Your task is to find the missing number.
 * Input:
 *  The first input line contains an integer n.
 *  The second line contains n−1 numbers. Each number is distinct and between 1 and n (inclusive).
 * Output:
 *  Print the missing number.
 * Constraints
 *  2≤n≤2*10^5
 * Example:
 *  Input:
 *    5
 *    2 3 1 5
 *  Output:
 *    4
 */
public class MissingNumber {

  public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    long n = Long.parseLong(sc.nextLine());
    String[] line = sc.nextLine().split(" ");
    long[] a = Arrays.stream(line).mapToLong(Long::parseLong).toArray();
    sc.close();
    // algorithm
    System.out.println(algorithm2(n, a));
  }

  /**
   * 1+2+3+...+n=(n(n+1))/2
   * Missing Number = (n(n+1))/2) - (a[1]+a[2]+...+a[n])
   * Missing Number = (n(n+1))/2)-a[1]-a[2]-...-a[n]
   * @param n
   * @param a
   */
  public static long algorithm1(long n, long[] a) {
    long sum = (n*(n+1))/2;
    return sum - Arrays.stream(a).sum();
  }

  /**
   * XOR(1...n) = xor of all numbers from 1 to n
   * Missing Number = XOR(1...n) XOR (a[1] XOR a[2] XOR...XOR a[n])
   * Missing Number = XOR(1...n) XOR a[1] XOR a[2] XOR...XOR a[n]
   * xor = (n>>1)&1 ^ (((n&1)>0)?1:n); //Thanks to https://a3nm.net/blog/xor.html for this implementation
   * xor = (n % 4 == 0) ? n : (n % 4 == 1) ? 1 : (n % 4 == 2) ? n + 1 : 0; // 1 XOR 2 XOR .... XOR N = {N if REMAINDER(N/4)=0, 1 if REMAINDER(N/4)=1, N+1 if REMAINDER(N/4)=2, 0 if REMAINDER(N/4)=3}
   * @param n
   * @param a
   */
  public static long algorithm2(long n, long[] a) {
    long xor = (n>>1)&1 ^ (((n&1)>0)?1:n);
    for (int i = 0; i < n - 1; i++) {
      xor ^= a[i];
    }
    return xor;
  }

}


