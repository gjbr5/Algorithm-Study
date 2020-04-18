package Problem01000s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int x = Integer.parseInt(st[0]), y = Integer.parseInt(st[1]),
                w = Integer.parseInt(st[2]), h = Integer.parseInt(st[3]);

        // 왼쪽 거리 x, 오른쪽 거리 w-x, 아래쪽 거리 y, 위쪽 거리 h-y 4가지 중에서 가장 짧은 쪽이 최단 경로
        System.out.println(Math.min(Math.min(x, w - x), Math.min(y, h - y)));
    }
}
