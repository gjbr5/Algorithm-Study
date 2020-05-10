package Problem02000s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob2606 {

    private static int infect(boolean[][] graph, int computer) {
        if (graph[0][computer]) // 방문했으면
            return 0; // 카운트 안함
        graph[0][computer] = true; // 방문 여부 체크
        int cnt = 0;
        for (int i = 1; i < graph.length; i++) {
            if (graph[computer][i])
                cnt += infect(graph, i); // 연결된 컴퓨터 감염
        }
        return 1 + cnt; // 현재 컴퓨터 + 현재 컴퓨터로 감염된 컴퓨터
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] graph = new boolean[n + 1][n + 1]; // 인접 행렬
        int t = Integer.parseInt(br.readLine());
        // 그래프 입력
        while (t-- > 0) {
            String[] atob = br.readLine().split(" ");
            int a = Integer.parseInt(atob[0]);
            int b = Integer.parseInt(atob[1]);
            graph[a][b] = true;
            graph[b][a] = true;
        }
        System.out.println(infect(graph, 1) - 1); // 1번 컴퓨터 제외
    }
}
