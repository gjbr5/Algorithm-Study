package Problem10000s;

import java.util.Scanner;

public class Prob10870 {

    private static int fibonacci(int n) {
        if (n == 0 || n == 1) // f(0) = 0, f(1) = 1
            return n;
        return fibonacci(n - 1) + fibonacci(n - 2); // f(n) = f(n-1) + f(n-2)
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(fibonacci(in.nextInt()));
    }
}
