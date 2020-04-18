package Problem04000s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob4948 {

    public static void main(String[] args) throws IOException {
        // 에라토스테네스의 체
        boolean[] sieve = new boolean[246913];
        sieve[0] = sieve[1] = true;
        for (int i = 2; i < sieve.length; i++) {
            if (!sieve[i]) {
                for (int j = i + i; j < sieve.length; j += i) {
                    sieve[j] = true;
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = Integer.parseInt(br.readLine()); i != 0; i = Integer.parseInt(br.readLine())) {
            // n보다 크고, 2n보다 작거나 같은 소수의 개수 세기
            int cnt = 0;
            for (int j = i + 1; j <= 2 * i; j++) {
                if (!sieve[j])
                    cnt++;
            }
            System.out.println(cnt);
        }
    }
}
