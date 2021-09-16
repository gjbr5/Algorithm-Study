package Problem09000s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob9663 {

    private static int find(int[] arr, int depth) {
        if (depth == arr.length) // 완성
            return 1;
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[depth] = i; // 퀸 두기(depth행 i열)
            for (int j = 0; j < depth; j++) {
                if (arr[depth] == arr[j] // 수직으로 만나는지 검사
                        || depth - j == Math.abs(arr[depth] - arr[j])) // 대각선으로 만나는지 검사
                {
                    arr[depth] = -1;
                    break;
                }
            }
            if (arr[depth] != -1) // 만나지 않는다면
                cnt += find(arr, depth + 1); // 다음 행 찾기
        }
        return cnt; // 최종 결과 합산
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(find(new int[n], 0));
    }
}
