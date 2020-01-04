import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob11729 {

    private static int cnt = 0; // 옮긴 횟수
    private static StringBuilder sb = new StringBuilder(); // 출력 버퍼

    private static void move(int n, int from, int stop, int to) {
        cnt++;
        if (n == 1) // 1개일 경우
            sb.append(from).append(' ').append(to).append('\n'); // 바로 목적지로 옮긴다.
        else {
            move(n - 1, from, to, stop); // 1 ~ (n-1)번 원판을 경유지로 옮기고
            sb.append(from).append(' ').append(to).append('\n'); // n번 원판을 목적지로 옮기고
            move(n - 1, stop, from, to); // 1 ~ (n-1)번 원판을 목적지로 옮긴다.
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        move(n, 1, 2, 3); // n개의 원판을 1번에서 2번을 거쳐 3번으로 옮기기
        System.out.println(cnt);
        System.out.print(sb);
    }
}
