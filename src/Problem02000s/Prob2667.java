package Problem02000s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Prob2667 {

    private static int numbering(char[][] map, int r, int c) {
        if (map[r][c] != '1')
            return 0; // 집이 아니거나 이미 방문한 곳
        map[r][c] = '0'; // 방문여부 체크
        int cnt = 0;
        if (r > 0) cnt += numbering(map, r - 1, c); // 상
        if (c > 0) cnt += numbering(map, r, c - 1); // 좌
        if (r + 1 != map.length) cnt += numbering(map, r + 1, c); // 하
        if (c + 1 != map[r].length) cnt += numbering(map, r, c + 1); // 우
        return 1 + cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        PriorityQueue<Integer> cnt = new PriorityQueue<>(); // 힙정렬
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) { // 모든 집 순회
                if (map[i][j] == '1') {
                    cnt.add(numbering(map, i, j)); // 번호 붙이기
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cnt.size()).append('\n'); // 단지의 수
        while (!cnt.isEmpty())
            sb.append(cnt.poll()).append('\n'); // 정렬해서 출력
        System.out.print(sb);
    }
}
