package Problem02000s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Prob2447 {

    private static char[][] p;

    private static void draw(int n, int x, int y) {
        if (n == 3) { // 최소 단위
            p[x][y] = p[x][y + 1] = p[x][y + 2] = '*';
            p[x + 1][y] = p[x + 1][y + 2] = '*';
            p[x + 2][y] = p[x + 2][y + 1] = p[x + 2][y + 2] = '*';
        } else {
            int p = n / 3;
            draw(p, x, y); // 좌상단
            draw(p, x, y + p); // 상단
            draw(p, x, y + 2 * p); // 우상단

            draw(p, x + p, y); // 좌측
            draw(p, x + p, y + 2 * p); // 우측

            draw(p, x + 2 * p, y); // 좌하단
            draw(p, x + 2 * p, y + p); // 하단
            draw(p, x + 2 * p, y + 2 * p); // 우하단
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        p = new char[n][n]; // 버퍼
        for (int i = 0; i < n; i++)
            Arrays.fill(p[i], ' '); // 공백으로 초기화
        draw(n, 0, 0);
        for (var a : p)
            System.out.println(a);
    }
}
