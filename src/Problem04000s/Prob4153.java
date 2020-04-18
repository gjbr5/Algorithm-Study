package Problem04000s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 각 변의 길이 a, b, c
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0 && c == 0) // 종료 조건
                break;

            // c가 가장 길도록 변경
            if (a > c) {
                int tmp = a;
                a = c;
                c = tmp;
            }
            if (b > c) {
                int tmp = b;
                b = c;
                c = tmp;
            }

            // 피타고라스의 정리
            if (a * a + b * b == c * c)
                System.out.println("right");
            else
                System.out.println("wrong");
        }
    }
}
