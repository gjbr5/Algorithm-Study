import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) // 찾는 수(1 ~ N -> 0 ~ N-1)
            arr[i] = Integer.parseInt(st.nextToken()) - 1;

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            if (arr[i] <= n / 2) // 찾는 수가 왼쪽에 있으면
                cnt += arr[i]; // 찾는 수만큼 왼쪽으로 이동
            else // 찾는 수가 오른쪽에 있으면
                cnt += n - arr[i]; // (n-찾는 수) 만큼 오른쪽으로 이동
            for (int j = i + 1; j < m; j++) {
                arr[j] = (arr[j] + n - arr[i]) % n; // 찾을 수들에 이동 반영
                arr[j] = (arr[j] + n - 2) % (n - 1); // 찾을 수들에 삭제 반영
            }
            n -= 1; // 크기가 줄어든 것 반영
        }
        System.out.println(cnt); // 총 이동횟수 출력
    }
}
