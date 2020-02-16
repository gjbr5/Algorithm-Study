import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob15650 {
    private static StringBuilder sb = new StringBuilder();
    private static int n, m;

    private static void find(int[] arr, int depth) {
        if (depth == m + 1) { // 조건을 만족하는 수열을 완성한 경우
            for (int i = 1; i <= m; i++)
                sb.append(arr[i]).append(' ');
            sb.append('\n'); // 출력
        } else {
            for (int i = arr[depth - 1] + 1; i <= n; i++) { // 중복 제거 및 모든 수열값 탐색
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
        System.out.println(sb);
    }

}
