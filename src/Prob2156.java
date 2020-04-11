import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wine = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++)
            wine[i] = Integer.parseInt(br.readLine());

        // 잔이 1개 이상
        dp[0] = wine[0];
        // 잔이 2개 이상
        if (n > 1)
            dp[1] = wine[0] + wine[1];
        // 잔이 3개 이상
        if (n > 2)
            dp[2] = Math.max(Math.max(wine[0] + wine[2], wine[1] + wine[2]), dp[1]);
        // 잔이 4개 이상
        // 마시지 않은 경우 f(n) = f(n-1)
        // 직전의 잔을 마시고 이번 잔을 마신 경우 f(n) = f(n-3) + a(n-1) + a(n)
        // 2전의 잔을 마시고 이번 잔을 마신 경우 f(n) = f(n-2) + a(n)
        for (int i = 3; i < n; i++)
            dp[i] = Math.max(Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]), dp[i - 1]);
        System.out.println(dp[n - 1]);
    }
}
