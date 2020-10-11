import java.util.Scanner;

/**
 * https://cses.fi/problemset/task/1094
 *
 * You are given a DNA sequence: a string consisting of characters A, C, G, and T. Your task is to find the longest repetition in the sequence. This is a maximum-length substring containing only one type of character.
 *
 * Input
 *
 * The only input line contains a string of n characters.
 *
 * Output
 *
 * Print one integer: the length of the longest repetition.
 *
 * Constraints
 * 1≤n≤10^6
 * Example
 *
 * Input:
 * ATTCGGGA
 *
 * Output:
 * 3
 */
public class Repetitions {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    System.out.print(glgorithm(str));
  }

  public static int glgorithm(String str) {
    char prevChar = '\0';
    int maxLength = 0;
    int curLength = 0;
    for (int i = 0; i < str.length(); i++) {
      char curChar = str.charAt(i);
      if(prevChar == curChar) {
        curLength++;
      } else {
        curLength = 1;
      }
      maxLength = Math.max(maxLength, curLength);
      prevChar = curChar;
    }
    return maxLength;
  }
}
