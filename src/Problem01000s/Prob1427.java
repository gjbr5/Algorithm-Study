package Problem01000s;

import java.io.IOException;
import java.io.InputStreamReader;

public class Prob1427 {
    public static void main(String[] args) throws IOException {
        // 계수 정렬(Counting Sort)
        int[] cnt = new int[10];
        try (InputStreamReader isr = new InputStreamReader(System.in)) {
            while (true) {
                int x = isr.read();
                if (x < '0' || x > '9')
                    break;
                cnt[x - '0']++;
            }
        }

        for (int i = 9; i >= 0; i--)
            System.out.print(String.valueOf(i).repeat(cnt[i])); // Java 11 String.repeat
    }
}
