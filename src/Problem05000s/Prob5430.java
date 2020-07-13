package Problem05000s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob5430 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            // 명령 입력
            char[] cmd = br.readLine().toCharArray();

            // 숫자 배열 입력
            String[] arr = new String[Integer.parseInt(br.readLine())];
            StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = st.nextToken();
            }
            int front = 0, rear = arr.length;
            boolean invert = false; // 배열이 뒤집혔는지 확인
            for (char c : cmd) {
                if (c == 'R') // R
                    invert = !invert;
                else if (invert) // D(inverted)
                    rear -= 1;
                else // D(not inverted)
                    front += 1;
                if (front > rear)
                    break;
            }
            // Output
            if (front > rear) // 에러
                sb.append("error\n");
            else if (front == rear) // 빈 배열
                sb.append("[]\n");
            else if (invert) { // 역순
                sb.append('[');
                for (int i = rear - 1; i > front; i--)
                    sb.append(arr[i]).append(',');
                sb.append(arr[front]).append("]\n");
            } else {
                sb.append('[');
                for (int i = front; i < rear - 1; i++)
                    sb.append(arr[i]).append(',');
                sb.append(arr[rear - 1]).append("]\n");
            }
        }
        System.out.println(sb);
    }
}
