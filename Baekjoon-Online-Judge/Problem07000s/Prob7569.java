package Problem07000s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Prob7569 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[][][] box = new int[h][n][m]; // 3차원 박스

        int remainTomatoes = 0;
        Queue<Location> queue = new LinkedList<>();

        // 입력
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    switch (st.nextToken().charAt(0)) {
                        case '0':
                            box[i][j][k] = 0;
                            remainTomatoes++;
                            break;
                        case '1':
                            box[i][j][k] = 1;
                            remainTomatoes++;
                            queue.add(new Location(i, j, k));
                            break;
                        case '-':
                            box[i][j][k] = -1;
                            break;
                    }
                }
            }
        }

        // 토마토가 없는 경우
        if (remainTomatoes == 0) {
            System.out.println(0);
            return;
        }

        int days = -1;
        do {
            // 모두 익지 못하는 경우
            if (queue.isEmpty()) {
                days = -1;
                break;
            }
            days++;
            int cnt = queue.size();
            while (cnt-- > 0) {
                Location location = queue.poll();
                int i = location.z;
                int j = location.y;
                int k = location.x;
                if (box[i][j][k] == -1) continue;
                box[i][j][k] = -1;
                remainTomatoes--;
                if (i > 0 && box[i - 1][j][k] != -1) queue.add(new Location(i - 1, j, k)); // 상
                if (j > 0 && box[i][j - 1][k] != -1) queue.add(new Location(i, j - 1, k)); // 전
                if (k > 0 && box[i][j][k - 1] != -1) queue.add(new Location(i, j, k - 1)); // 좌
                if (i < h - 1 && box[i + 1][j][k] != -1) queue.add(new Location(i + 1, j, k)); // 하
                if (j < n - 1 && box[i][j + 1][k] != -1) queue.add(new Location(i, j + 1, k)); // 후
                if (k < m - 1 && box[i][j][k + 1] != -1) queue.add(new Location(i, j, k + 1)); // 우
            }
        } while (remainTomatoes != 0);
        System.out.println(days);
    }

    private static class Location {
        int z;
        int y;
        int x;

        public Location(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }
}
