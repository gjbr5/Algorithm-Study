import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Prob11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // Point 클래스 힙 정렬
        PriorityQueue<Point> pq=new PriorityQueue<>(n);
        for (int i = 0; i < n; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            pq.offer(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        for (int i = 0; i < n; i++) {
            System.out.println(pq.poll());
        }
    }

    private static class Point implements Comparable<Point> {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return y == o.y ? x - o.x : y - o.y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}
