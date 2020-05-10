package Problem01000s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Prob1260 {

    private static CharSequence dfs(boolean[][] graph, int v) {
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[graph.length]; // 방문한 노드 체크
        Stack<Integer> stack = new Stack<>(); // DFS - 스택 사용
        stack.push(v); // 루트 노드
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (visited[node]) // 방문한 노드 Pass
                continue;
            sb.append(node).append(' '); // 노드 방문
            visited[node] = true; // 방문한 노드 Check
            for (int i = graph[node].length - 1; i >= 1; i--) {
                if (graph[node][i])
                    stack.push(i); // Successors
            }
        }
        return sb;
    }

    private static CharSequence bfs(boolean[][] graph, int v) {
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[graph.length]; // 방문한 노드 체크
        Queue<Integer> queue = new LinkedList<>(); // BFS - 큐 사용
        queue.add(v); // 루트 노드
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (visited[node]) // 방문한 노드 Pass
                continue;
            sb.append(node).append(' '); // 노드 방문
            visited[node] = true; // 방문한 노드 Check
            for (int i = 1; i < graph[node].length; i++) {
                if (graph[node][i])
                    queue.add(i); // Successors
            }
        }
        return sb;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        boolean[][] graph = new boolean[n + 1][n + 1]; // 인접 행렬
        // 그래프 입력
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = true;
        }
        System.out.println(dfs(graph, v)); // DFS
        System.out.println(bfs(graph, v)); // BFS
    }
}
