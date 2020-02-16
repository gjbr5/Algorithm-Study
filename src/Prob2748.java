import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob2748 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long a = 0, b = 1, sum = n; // Overflow 주의
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        System.out.println(sum);
    }
}
