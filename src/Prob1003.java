import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob1003 {

    private static int[][] dp = new int[2][41];

    private static void findDP(int n) {
        if (dp[0][n] > 0 || dp[1][n] > 0) // 채워짐
            return;
        if (n == 0) { // 0일 때
            dp[0][0] = 1;
            dp[1][0] = 0;
        } else if (n == 1) { // 1일 때
            findDP(n - 1);
            dp[0][1] = 0;
            dp[1][1] = 1;
        } else { // n >1일 때
            findDP(n - 1);
            dp[0][n] = dp[0][n - 1] + dp[0][n - 2];
            dp[1][n] = dp[1][n - 1] + dp[1][n - 2];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        findDP(40);
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[0][n]).append(' ').append(dp[1][n]).append('\n');
        }
        System.out.print(sb);
    }
}

