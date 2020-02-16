import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob15649 {

    private static void find(int n, int m, int depth, StringBuilder out, int[] arr, boolean[] check) {
        if (depth == m) { // 조건을 만족하는 수열을 완성한 경우
            out.append(arr[0]);
            for (int i = 1; i < depth; i++)
                out.append(' ').append(arr[i]);
            out.append('\n'); // 출력
        } else {
            for (int i = 1; i <= n; i++) { // 현재 depth의 모든 수열값을 검색
                if (check[i]) // 중복 검사
                    continue;
                arr[depth] = i; // 현재 depth의 수열 값
                check[i] = true;
                find(n, m, depth + 1, out, arr, check); // 다음 depth의 수열 검색
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]), m = Integer.parseInt(nm[1]);

        int[] arr = new int[n];
        boolean[] check = new boolean[n + 1];

        StringBuilder out = new StringBuilder();
        find(n, m, 0, out, arr, check);
        System.out.print(out);
    }
}
