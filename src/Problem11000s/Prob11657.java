package Problem11000s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob11657 {

    static final long INF = 9000000000000000000L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        // Input
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken()) - 1;
            graph.get(src).add(new Edge(st.nextToken(), st.nextToken()));
        }

        try {
            // Process
            long[] distance = bellmanFord(graph);

            // Output
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < distance.length; i++)
                sb.append(distance[i] == INF ? -1 : distance[i]).append("\n");
            System.out.print(sb);
        } catch (NegativeWeightCycleException e) {
            System.out.println("-1");
        }
    }

    static long[] bellmanFord(ArrayList<ArrayList<Edge>> graph) throws NegativeWeightCycleException {
        // 1. 변수 초기화
        long[] distance = new long[graph.size()];
        Arrays.fill(distance, INF);
        distance[0] = 0;

        // 2. 벨먼 포드 알고리즘 수행
        for (int i = 0; i < graph.size(); i++) {
            for (int src = 0; src < graph.size(); src++) {
                for (Edge edge : graph.get(src)) {
                    if (distance[src] == INF)
                        continue;
                    distance[edge.dst] = Math.min(distance[edge.dst], distance[src] + edge.weight);
                }
            }
        }

        // 3. 음의 사이클 검사
        for (int src = 0; src < graph.size(); src++) {
            for (Edge edge : graph.get(src)) {
                if (distance[src] == INF)
                    continue;
                long newDistance = distance[src] + edge.weight;
                if (newDistance < distance[edge.dst])
                    throw new NegativeWeightCycleException();
            }
        }
        return distance;
    }

    static class Edge {
        int dst;
        long weight;

        public Edge(String dst, String weight) {
            this.dst = Integer.parseInt(dst) - 1;
            this.weight = Long.parseLong(weight);
        }
    }

    static class NegativeWeightCycleException extends Exception {
    }

}
