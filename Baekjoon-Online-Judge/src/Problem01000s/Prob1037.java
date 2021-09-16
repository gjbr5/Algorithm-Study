package Problem01000s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = Integer.MAX_VALUE; // 가장 작은 약수
        int max = Integer.MIN_VALUE; // 가장 큰 약수
        while (n-- > 0) {
            int f = Integer.parseInt(st.nextToken()); // 약수
            if (min > f)
                min = f;
            if (max < f)
                max = f;
        }
        System.out.println(min * max); // 곱하면 원래 수
    }
}
