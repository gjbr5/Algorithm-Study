package Problem15000s;

import java.io.*;
import java.util.StringTokenizer;

public class Prob15651 {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int n, m;

    private static void find(int[] arr, int depth) throws IOException {
        if (depth == m + 1) { // 조건을 만족하는 수열을 완성한 경우
            for (int i = 1; i <= m; i++)
                bw.write(arr[i] + " ");
            bw.write('\n'); // 출력
        } else {
            for (int i = 1; i <= n; i++) { // 모든 수열값 탐색
                arr[depth] = i;
                find(arr, depth + 1); // 다음 수열값 탐색
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        find(new int[n + 1], 1);
        bw.flush();
    }
}
