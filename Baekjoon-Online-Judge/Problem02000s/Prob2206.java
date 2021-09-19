package Problem02000s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Prob2206 {

    static void printLength(Node goal, Map<Node, Node> route) {
        int len = 0;
        Node node = goal;
        // 경로 찾기
        while (node != null) {
            node = route.get(node);
            len += 1; // 경로 길이
        }
        System.out.println(len);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][m]; // 맵
        for (int i = 0; i < n; i += 1) {
            map[i] = br.readLine().toCharArray();
        }
        Queue<Node> queue = new LinkedList<>();
        Map<Node, Node> route = new TreeMap<>();
        Node root = new Node(0, 0, false); // 시작 위치
        queue.offer(root);
        route.put(root, null);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.y == n - 1 && node.x == m - 1) { // 종료 조건
                printLength(node, route);
                return;
            }
            // 후속 노드
            int[][] successors = {{node.y - 1, node.x}, {node.y + 1, node.x}, {node.y, node.x - 1}, {node.y, node.x + 1}};
            for (int[] succPos : successors) {
                // 바운더리 체크
                if (succPos[0] < 0 || succPos[0] > n - 1 || succPos[1] < 0 || succPos[1] > m - 1) continue;
                // 벽 부수기 체크
                if (node.breaked && map[succPos[0]][succPos[1]] == '1') continue;
                // 후속 노드 생성
                Node successor = new Node(succPos[0], succPos[1], node.breaked || map[succPos[0]][succPos[1]] == '1');
                // 이미 갔던 곳이면 버림
                if (route.containsKey(successor)) continue;
                // 큐에 추가
                queue.offer(successor);
                route.put(successor, node); // 경로 추가
            }
        }
        // 갈 수 없는 경우
        System.out.println(-1);
    }

    static class Node implements Comparable<Node> {
        int y;
        int x;
        boolean breaked;

        public Node(int y, int x, boolean breaked) {
            this.y = y;
            this.x = x;
            this.breaked = breaked;
        }

        @Override
        public int compareTo(Node o) {
            if (y != o.y) return y - o.y;
            if (x != o.x) return x - o.x;
            if (breaked == o.breaked) return 0;
            if (breaked) return 1;
            else return -1;
        }
    }
}
