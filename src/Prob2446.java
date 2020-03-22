import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob2446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 위쪽 절반
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1 - i; j++) {
                if (j < i)
                    sb.append(' ');
                else
                    sb.append('*');
            }
            sb.append('\n');
        }

        // 아래쪽 절반
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < 2 * n - 1 - i; j++) {
                if (j < i)
                    sb.append(' ');
                else
                    sb.append('*');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
