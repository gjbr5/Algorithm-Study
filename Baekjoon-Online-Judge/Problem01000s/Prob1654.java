package Problem01000s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] kn = br.readLine().split(" ");
        int k = Integer.parseInt(kn[0]);
        int n = Integer.parseInt(kn[1]);
        int[] arr = new int[k];
        long start = 1, end = 0; // 랜선의 최소 길이 = 1
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            end += arr[i];
        }
        end /= n; // 이론상 최대 길이 = avg(arr)

        // 1 ~ avg(arr) 범위에서 이진 탐색
        while (start <= end) {
            long mid = (start + end) / 2;
            // 대소 판단 기준 = 만들 수 있는 랜선의 수
            int cnt = 0;
            for (int i = 0; i < k; i++) {
                cnt += arr[i] / mid;
            }
            if (cnt < n)
                end = mid - 1;
            else // 같은 경우 길이 증가
                start = mid + 1;
        }
        System.out.println(end);
    }
}
