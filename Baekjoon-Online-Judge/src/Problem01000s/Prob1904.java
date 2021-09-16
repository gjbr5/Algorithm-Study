package Problem01000s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob1904 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n >= 3 ? n + 1 : 3]; // 최소 크기: 3
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++)
            dp[i] = (dp[i - 2] + dp[i - 1]) % 15746; // f(n) = (f(n-2) + f(n-1)) % 15746
        System.out.println(dp[n]);
    }
}
