package Problem01000s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob1436 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        // 종말의 숫자 찾기
        for (int i = 666; cnt <= 10000; i++) {
            String s = String.valueOf(i);
            for (int j = 0; j <= s.length() - 3; j++) {
                if (s.charAt(j) == '6' && s.charAt(j + 1) == '6' && s.charAt(j + 2) == '6') {
                    if (++cnt == n) { // cnt번째 종말의 숫자
                        System.out.println(s); // n번째 종말의 숫자 출력
                        return;
                    }
                    break; // 다음 종말의 숫자 찾기
                }
            }
        }
    }
}
