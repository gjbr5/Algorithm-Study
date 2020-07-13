package Problem01000s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Prob1753 {

    static final int INF = 10000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine()) - 1;
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++)
            graph.add(new ArrayList<>());

        // Input
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, w));
        }

        // Dijkstra
        int[] dist = new int[v];
        Arrays.fill(dist, INF);
        dist[k] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(k, 0));
        boolean[] visited = new boolean[v];
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

        StringBuilder sb = new StringBuilder();
        for (int d : dist) {
            if (d == INF)
                sb.append("INF\n");
            else
                sb.append(d).append('\n');
        }
        System.out.print(sb);
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
