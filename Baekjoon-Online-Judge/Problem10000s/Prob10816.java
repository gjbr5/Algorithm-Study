package Problem10000s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob10816 {

    private static int searchAndCount(int[] arr, int key) {
        int start = 0, end = arr.length - 1;
        while (start <= end) { // Lower Bound
            int mid = (start + end) / 2;
            if (arr[mid] < key)
                start = mid + 1;
            else
                end = mid - 1;
        }
        int lBound = end + 1;

        start = 0;
        end = arr.length - 1;
        while (start <= end) { // Upper Bound
            int mid = (start + end) / 2;
            if (arr[mid] <= key)
                start = mid + 1;
            else
                end = mid - 1;
        }
        int rBound = start - 1;

        // Upper Bound - Lower Bound + 1 = 총 개수
        return rBound - lBound + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[Integer.parseInt(br.readLine())];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // 정렬
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            // 찾아서 출력
            sb.append(searchAndCount(arr, Integer.parseInt(st.nextToken()))).append(' ');
        }
        System.out.print(sb);
    }
}
