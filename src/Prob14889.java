import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob14889 {

    private static int[][] stat;
    private static int min = Integer.MAX_VALUE;

    private static void find(int[] arr, int depth) {
        if (min == 0) return; // 최솟값 최적화
        if (depth == arr.length) { // 팀원 결정되었을 때
            int start = 0; // Start 팀 능력치
            // Start 팀 능력치 구하기
            for (int p1 : arr)
                for (int p2 : arr)
                    start += stat[p1][p2];

            int link = 0; // Link 팀 능력치
            int[] linkArr = new int[arr.length]; // 링크 팀 팀원 배열
            for (int p = 0, s = 0, l = 0; p < stat.length; p++) {
                if (s >= arr.length)
                    linkArr[l++] = p;
                else if (p != arr[s])
                    linkArr[l++] = p;
                else
                    s++;
            }
            // Link 팀 능력치 구하기
            for (int p1 : linkArr)
                for (int p2 : linkArr)
                    link += stat[p1][p2];

            // 결과
            int result = Math.abs(start - link);
            if (min > result)
                min = result;
            return;
        }

        // 가능한 Start 팀원들 구하기
        for (int i = depth == 0 ? 0 : arr[depth - 1] + 1; i < stat.length; i++) {
            arr[depth] = i;
            find(arr, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        stat = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                stat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 탐색
        find(new int[n / 2], 0);

        // 출력
        System.out.println(min);
    }
}
