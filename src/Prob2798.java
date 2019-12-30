import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob2798 {

    public static void main(String[] args) {
        try {
            // N, M 입력
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer tok = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(tok.nextToken());
            int m = Integer.parseInt(tok.nextToken());

            // 카드 숫자 입력
            tok = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(tok.nextToken());

            // 정렬
            Arrays.sort(arr);
            int max = -1;

            // 모든 경우의 수 찾기
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        // 카드 3장의 합
                        int sum = arr[i] + arr[j] + arr[k];
                        // 합은 m보다 크지 않음
                        if (sum > m)
                            break;
                        // 최댓값 찾기
                        if (sum > max)
                            max = sum;
                    }
                }
            }
            System.out.println(max);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
