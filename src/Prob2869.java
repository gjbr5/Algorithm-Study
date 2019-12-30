import java.util.Scanner;

public class Prob2869 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt(), b = in.nextInt(), v = in.nextInt();
        System.out.println((v - b) / (a - b));
    }
}
