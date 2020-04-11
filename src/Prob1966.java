import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            // n, m 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            // 중요도 배열
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st.nextToken());
            int cnt = 0;
            int front = 0;
            do {
                // 출력된 문서 건너뛰기
                while (arr[front] == 0)
                    front = (front + 1) % n;
                // 우선순위가 높은 문서 찾기
                for (int i = (front + 1) % n; i != front; i = (i + 1) % n) {
                    while (arr[i] > arr[front]) { // 붙어있는 경우도 탐색
                        front = i;
                        i = (front + 1) % n; // 우선순위가 더 높은 문서 찾기
                    }
                }
                // 문서 출력
                arr[front] = 0;
                cnt += 1;
            } while (front != m);
            sb.append(cnt).append('\n');
        }
        System.out.print(sb);
    }
}
