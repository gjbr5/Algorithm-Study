package Problem01000s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++)
            sb.append(br.readLine()).append(' ');
        StringTokenizer st = new StringTokenizer(sb.toString());

        // 슬라이딩 윈도우
        int[][] dp = new int[2][3];
        for (int i = 0; i < n; i++) {
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dp[i % 2][0] = r + Math.min(dp[(i + 1) % 2][1], dp[(i + 1) % 2][2]); // 마지막 집을 빨간색으로 칠할 때
            dp[i % 2][1] = g + Math.min(dp[(i + 1) % 2][0], dp[(i + 1) % 2][2]); // 마지막 집을 초록색으로 칠할 때
            dp[i % 2][2] = b + Math.min(dp[(i + 1) % 2][0], dp[(i + 1) % 2][1]); // 마지막 집을 파란색으로 칠할 때
        }

        // 셋 중에서 가장 작은 비용 출력
        System.out.println(Math.min(Math.min(dp[(n - 1) % 2][0], dp[(n - 1) % 2][1]), dp[(n - 1) % 2][2]));
    }
}
