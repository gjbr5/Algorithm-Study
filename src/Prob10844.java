import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[2][10];
        dp[0][0] = 0;
        for (int i = 1; i < 10; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            int prev = (i + 1) % 2; // 길이가 i-1인 계단수
            int now = i % 2; // 길이가 i인 계단수
            dp[now][0] = dp[prev][1]; // 1->0
            dp[now][9] = dp[prev][8]; // 8->9
            for (int j = 1; j < 9; j++) {
                dp[now][j] = (dp[prev][j - 1] + dp[prev][j + 1]) % 1000000000; // n-1->n, n+1->n
            }
        }
        int ans = 0;
        for (int i = 0; i < 10; i++) {
            ans = (ans + dp[(n - 1) % 2][i]) % 1000000000;
        }
        System.out.println(ans);
    }
}
