package Problem01000s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Prob1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 힙 정렬
        PriorityQueue<String> pq = new PriorityQueue<>(n, (String o1, String o2) -> {
            if (o1.length() == o2.length())
                return o1.compareTo(o2);
            return o1.length() - o2.length();
        });
        for (int i = 0; i < n; i++) {
            pq.offer(br.readLine());
        }

        StringBuilder sb = new StringBuilder(); // 출력 버퍼 문자열
        String dup = pq.poll();
        sb.append(dup).append('\n');
        while (!pq.isEmpty()) {
            String s = pq.poll();
            if (s.equals(dup)) // 중복 검사
                continue;
            dup = s;
            sb.append(s).append('\n'); // 중복이 아닐 경우 출력
        }
        System.out.print(sb);
    }
}
