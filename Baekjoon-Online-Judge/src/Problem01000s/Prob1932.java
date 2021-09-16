package Problem01000s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 한 줄 입력
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }

            // 각 줄마다
            if (i > 0) {
                for (int j = 0; j <= i; j++) {
                    if (j == 0) // 맨 왼쪽
                        arr[i][j] += arr[i - 1][j];
                    else if (j == i) // 맨 오른쪽
                        arr[i][j] += arr[i - 1][j - 1];
                    else // 둘 중에 큰 쪽을 선택
                        arr[i][j] += Math.max(arr[i - 1][j - 1], arr[i - 1][j]);
                }
            }
        }
        // 마지막 줄에서 가장 큰 값 찾기
        int max = -1;
        for (int i = 0; i < n; i++) {
            if (max < arr[n - 1][i])
                max = arr[n - 1][i];
        }
        // 출력
        System.out.println(max);
    }
}
