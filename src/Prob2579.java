import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stairs = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = stairs[0];
        if (n > 1)
            dp[1] = stairs[0] + stairs[1];
        if (n > 2)
            dp[2] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);

        // 1칸 올라온 경우 f(n) = a(n) + a(n-1) + f(n-3)
        // 2칸 올라온 경우 f(n) = a(n) + f(n-2)
        for (int i = 3; i < n; i++)
            dp[i] = Math.max(dp[i - 2] + stairs[i], dp[i - 3] + stairs[i - 1] + stairs[i]);

        System.out.println(dp[n - 1]);
    }
}
