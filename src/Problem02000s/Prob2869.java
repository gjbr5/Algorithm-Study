package Problem02000s;

import java.util.Scanner;

public class Prob2869 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt(), b = in.nextInt(), v = in.nextInt();

        // (n-1)(A-B)+A >= V
        // => n >= (V-B)/(A-B)
        if ((v - b) % (a - b) == 0) {
            System.out.println((v - b) / (a - b));
        } else {
            System.out.println((v - b) / (a - b) + 1);
        }
    }
}
