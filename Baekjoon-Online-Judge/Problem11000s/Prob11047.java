package Problem11000s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        for (int i = n - 1; i >= 0; i--) { // 높은 가치의 동전부터
            cnt += k / coin[i]; // 최대한 사용
            k %= coin[i]; // 잔돈 계산
        }
        System.out.println(cnt);
    }
}
