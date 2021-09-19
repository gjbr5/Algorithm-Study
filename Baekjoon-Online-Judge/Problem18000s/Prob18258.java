package Problem18000s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] queue = new int[n]; // 큐의 최대 크기 = n
        int front = 0, back = 0; // 큐의 맨 앞과 맨 뒤를 가리키는 변수
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            String cmd = br.readLine();
            switch (cmd.charAt(0)) {
                case 'p':
                    if (cmd.charAt(1) == 'u') // push
                        queue[back++] = Integer.parseInt(cmd.split(" ")[1]);
                    else // pop
                        sb.append(front == back ? -1 : queue[front++]).append('\n');
                    break;
                case 's': // size
                    sb.append(back - front).append('\n');
                    break;
                case 'e': // empty
                    sb.append(front == back ? 1 : 0).append('\n');
                    break;
                case 'f': // front
                    sb.append(front == back ? -1 : queue[front]).append('\n');
                    break;
                case 'b': // back
                    sb.append(front == back ? -1 : queue[back - 1]).append('\n');
                    break;
            }
        }
        System.out.print(sb);
    }
}
