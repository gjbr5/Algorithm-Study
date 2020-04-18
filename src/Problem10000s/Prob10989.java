package Problem10000s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob10989 {

    // arr : 정렬할 배열
    // nBuckets : bucket의 수(정렬할 기수)
    // maxValue : 입력 범위의 최댓값
    private static void radixSort(int[] arr, int nBuckets, int maxValue) {
        int maxRadix = 1; // 언제까지 반복할지 계산
        while (maxRadix < maxValue)
            maxRadix *= nBuckets;

        int[][] bucket = new int[nBuckets][arr.length]; // bucket 생성
        for (int radix = 1; radix <= maxRadix; radix *= nBuckets) {
            int[] size = new int[nBuckets]; // 각 bucket의 크기
            for (int x : arr) {
                int which = (x / radix) % nBuckets; // which 번째 bucket에 넣음
                bucket[which][size[which]] = x;
                size[which]++; // bucket의 크기 1 증가
            }

            // bucket에 있는 수들을 원래 배열로 옮김
            for (int i = 0, startPos = 0; i < nBuckets; i++) {
                System.arraycopy(bucket[i], 0, arr, startPos, size[i]);
                startPos += size[i];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 배열 입력
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        // 기수 정렬
        radixSort(arr, 2, 10000);

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int x : arr)
            sb.append(x).append('\n');
        System.out.print(sb);
    }
}
