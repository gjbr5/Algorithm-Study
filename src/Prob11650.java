import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Prob11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // Map.Entry 힙 정렬
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(n, (var o1, var o2) -> {
            if (o1.getKey().equals(o2.getKey()))
                return o1.getValue() - o2.getValue();
            return o1.getKey() - o2.getKey();
        });
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.offer(Map.entry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        while(!pq.isEmpty()) {
            var item = pq.poll();
            System.out.println(item.getKey() + " " + item.getValue());
        }
    }
}
