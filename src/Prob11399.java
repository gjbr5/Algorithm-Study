import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] line = new int[n];
        for (int i = 0; i < n; i++) {
            line[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(line); // 빠른 시간안에 되도록 줄서기
        int sum = line[0];
        for (int i = 1; i < n; i++) {
            line[i] += line[i - 1]; // 필요한 총 시간
            sum += line[i]; // 필요한 시간의 합
        }
        System.out.println(sum);
    }
}
