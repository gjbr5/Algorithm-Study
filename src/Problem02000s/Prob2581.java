package Problem02000s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob2581 {
    public static void main(String[] args) {
        // 에라토스테네스의 체(~10,000)
        boolean[] prime = new boolean[10001];
        prime[0] = prime[1] = true;
        for (int i = 0; i < 10001; i++) {
            if (!prime[i])
                for (int j = i * 2; j < 10001; j += i)
                    prime[j] = true;
        }

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            // M, N 입력
            int m = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int sum = 0;
            int min = -1;

            // 소수인지 검사
            for (int i = m; i <= n; i++) {
                if (!prime[i]) {
                    sum += i;
                    if (min == -1)
                        min = i;
                }
            }
            if (min == -1)
                System.out.println(-1);
            else {
                System.out.println(sum);
                System.out.println(min);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
