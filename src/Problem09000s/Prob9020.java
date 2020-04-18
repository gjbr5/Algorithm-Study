package Problem09000s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob9020 {
    public static void main(String[] args) throws IOException {
        // 에라토스테네스의 체
        boolean[] sieve = new boolean[10001];
        sieve[0] = sieve[1] = true;
        for (int i = 2; i < sieve.length; i++) {
            if (!sieve[i]) {
                for (int j = i + i; j < sieve.length; j += i) {
                    sieve[j] = true;
                }
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트케이스
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            // (n/2)부터 소수를 찾아가며 골드바흐 파티션 출력
            for (int p = n / 2; p >= 2; p--) {
                if (!sieve[p] && !sieve[n - p]) {
                    System.out.println(p + " " + (n - p));
                    break;
                }
            }
        }
    }
}
