package Problem11000s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int size = 0;
        while (n-- > 0) {
            int x = Integer.parseInt(st.nextToken()); // 슬라이딩 윈도우
            int start = 1;
            int end = size; // dp 배열의 크기 = [1, size]
            while (start <= end) { // 이진 탐색
                int mid = (start + end) / 2;
                if (dp[mid] < x)
                    start = mid + 1;
                else if (dp[mid] > x)
                    end = mid - 1;
                else {
                    start = mid;
                    break;
                }
            }
            if (start > size) { // 새로운 LIS가 나오면
                size++;
            }
            dp[start] = x; // dp 배열 업데이트
        }
        System.out.println(Arrays.toString(dp)); // dp 배열의 길이 = LIS의 길이
    }
}
