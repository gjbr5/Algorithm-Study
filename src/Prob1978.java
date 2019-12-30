import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob1978 {
    public static void main(String[] args) {
        // 에라토스테네스의 체(~1,000)
        boolean[] flags = new boolean[1001];
        flags[0] = flags[1] = true;
        for (int i = 2; i <= 1000; i++)
            if (!flags[i])
                for (int j = i + i; j <= 1000; j += i)
                    flags[j] = true;

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            StringTokenizer tok = new StringTokenizer(br.readLine());
            int cnt = 0;

            // 소수 판별
            for (int i = 0; i < n; i++)
                if (!flags[Integer.parseInt(tok.nextToken())])
                    cnt++;

            System.out.println(cnt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
