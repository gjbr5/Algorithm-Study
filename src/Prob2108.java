import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Prob2108 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 숫자 n개
        int n = Integer.parseInt(br.readLine());

        // 숫자 입력
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        // 정렬
        Arrays.sort(arr);

        double avg = arr[0]; //평균
        int mode = arr[0]; // 최빈값
        int freq = 1; // 빈도
        int cnt = 1;
        boolean second = false; // 두번째 작은 수인지 판별
        for (int i = 1; i < n; i++) {
            // 평균 구하기
            avg += arr[i];

            // 빈도 계산
            if (arr[i - 1] == arr[i])
                cnt++;
            else
                cnt = 1;

            if (cnt > freq) { // 최빈값
                freq = cnt;
                mode = arr[i];
                second = false;
            } else if (cnt == freq && !second) { // 최빈값 중 두번째로 작은 수
                mode = arr[i];
                second = true;
            }
        }
        avg /= n; // 평균 구하기
        System.out.println(avg > 0 ? (int) (avg + 0.5) : (int) (avg - 0.5)); // 평균 반올림 후 출력
        System.out.println(arr[n / 2]); // 중앙값
        System.out.println(mode); // 최빈값
        System.out.println(arr[n - 1] - arr[0]); // 범위
    }

}
