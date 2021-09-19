package Problem11000s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int sqrt = (int) Math.sqrt(n); // 최대 sqrt(n)까지만 검사
        for (int i = 2; i <= sqrt || n != 1; ) { // 2부터 순서대로(에라토스테네스의 체)
            if (n % i == 0) {
                n /= i;
                sb.append(i).append('\n');
            } else
                i++;
        }
        System.out.print(sb);
    }
}
