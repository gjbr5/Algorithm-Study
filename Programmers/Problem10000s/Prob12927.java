import java.util.Comparator;
import java.util.PriorityQueue;

public class Prob12927 {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int w : works)
            pq.add(w);
        while (n-- > 0) {
            int w = pq.poll();
            if (w == 0)
                break;
            w -= 1;
            pq.add(w);
        }
        long answer = 0;
        for (int i : pq)
            answer += i * i;
        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        int[] works = { 1, 1 };
        System.out.println(new Prob12927().solution(n, works));
    }
}