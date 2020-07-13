package Problem01000s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Prob1504 {

    static final int INF = 500000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 정점의 개수
        int n = Integer.parseInt(st.nextToken());
        // 간선의 개수
        int e = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>(e));

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken()) - 1;
        int v2 = Integer.parseInt(st.nextToken()) - 1;

        // 1번 정점에서 출발하는 최단 경로
        int[] d1 = dijkstra(graph, 0);
        // V1에서 출발하는 최단 경로
        int[] dV1 = dijkstra(graph, v1);
        // V2에서 출발하는 최단 경로
        int[] dV2 = dijkstra(graph, v2);
        // 1번-V1-V2-N번 vs 1번-V2-V1-N번 경로 중 짧은 경로 선택
        int sum = Math.min(d1[v1] + dV1[v2] + dV2[n - 1], d1[v2] + dV2[v1] + dV1[n - 1]);

        if (sum >= INF) // 경로가 존재하지 않을 경우
            System.out.println("-1"); // -1 출력
        else // 경로가 존재하면
            System.out.println(sum); // 경로의 길이 출력
    }

    static int[] dijkstra(ArrayList<ArrayList<Edge>> graph, int start) {
        int[] dist = new int[graph.size()];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        boolean[] visited = new boolean[graph.size()];
        while (!pq.isEmpty()) {
            int a = pq.poll().v;
            if (visited[a]) continue;
            ArrayList<Edge> neighbors = graph.get(a);
            for (Edge n : neighbors) {
                int b = n.v;
                int nd = dist[a] + n.c;
                if (nd < dist[b]) {
                    dist[b] = nd;
                    pq.add(new Edge(b, nd));
                }
            }
            visited[a] = true;
        }
        return dist;
    }

    static class Edge implements Comparable<Edge> {
        int v;
        int c;

        public Edge(int v, int c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(Edge o) {
            return c - o.c;
        }
    }
}
