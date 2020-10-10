import java.util.Scanner;

public class WeirdAlgorithm {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        // algorithm
        output(n);
    }

    static void output(long n) {
        if(n == 1) {
            System.out.format("%d", n);
        } else {
            System.out.format("%d ", n);
            output(n%2 == 0 ? n/2 : n*3 + 1);
        }
    }
}
