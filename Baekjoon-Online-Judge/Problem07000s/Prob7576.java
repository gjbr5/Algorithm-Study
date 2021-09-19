package Problem07000s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Prob7576 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] box = new int[n][m]; // 토마토 상자

        int remainTomatoes = 0; // 남은 토마토 수
        Queue<Location> queue = new LinkedList<>();

        // 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                switch (st.nextToken().charAt(0)) {
                    case '0':
                        box[i][j] = 0;
                        remainTomatoes++;
                        break;
                    case '1':
                        box[i][j] = 1;
                        remainTomatoes++;
                        queue.add(new Location(i, j));
                        break;
                    case '-':
                        box[i][j] = -1;
                        break;
                }
            }
        }

        // 토마토가 없는 경우
        if (remainTomatoes == 0) {
            System.out.println(0);
            return;
        }

        int days = -1; // 날짜
        do {
            // 모두 익지 못하는 경우
            if (queue.isEmpty()) {
                days = -1;
                break;
            }
            days++; // 하루가 지남
            int cnt = queue.size(); // 오늘 익을 칸의 수
            while (cnt-- > 0) {
                Location location = queue.poll(); // 큐에서 꺼냄
                int i = location.y;
                int j = location.x;
                if (box[i][j] == -1) continue; // 빈 칸이면 건너뜀
                box[i][j] = -1; // 토마토가 익으면 상자에서 꺼냄
                remainTomatoes--;
                if (i > 0 && box[i - 1][j] != -1) queue.add(new Location(i - 1, j)); // 상
                if (j > 0 && box[i][j - 1] != -1) queue.add(new Location(i, j - 1)); // 좌
                if (i < n - 1 && box[i + 1][j] != -1) queue.add(new Location(i + 1, j)); // 하
                if (j < m - 1 && box[i][j + 1] != -1) queue.add(new Location(i, j + 1)); // 우
            }
        } while (remainTomatoes != 0);
        System.out.println(days);
    }

    private static class Location {
        int y;
        int x;

        public Location(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
