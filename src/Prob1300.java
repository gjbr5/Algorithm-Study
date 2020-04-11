import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(br.readLine());
        long k = Integer.parseInt(br.readLine());
        long start = 1, end = k; // B[k]의 값은 항상 k 이하
        while (start <= end) { // 값으로 인덱스 찾기
            long mid = (start + end) / 2;
            long idx = 0;
            // i번째 행에서 mid 보다 작은 수는 min(mid/i, n)개
            for (long i = 1; i <= n; i++) {
                idx += Math.min(mid / i, n);
            }
            if (idx < k)
                start = mid + 1;
            else // 같은 경우 더 작은 쪽
                end = mid - 1;
        }
        // start = B[k]
        System.out.println(start);
    }
}
