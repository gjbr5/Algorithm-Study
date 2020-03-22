import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob10996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb1 = new StringBuilder(); // "* * * ..."
        StringBuilder sb2 = new StringBuilder(); // " * * *..."

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                sb1.append('*');
                sb2.append(' ');
            } else {
                sb1.append(' ');
                sb2.append('*');
            }
        }

        // n번 반복
        for (int i = 0; i < n; i++) {
            sb.append(sb1).append('\n').append(sb2).append('\n');
        }
        System.out.print(sb);
    }
}
