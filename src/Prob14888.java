import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob14888 {

    private static int[] arr, op = new int[4];
    private static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    private static void find(int depth, int result) {
        if (depth == arr.length) {
            if (max < result)
                max = result;
            if (min > result)
                min = result;
            return;
        }
        if (op[0] > 0) { // add
            op[0]--;
            find(depth + 1, result + arr[depth]);
            op[0]++;
        }
        if (op[1] > 0) { // subtract
            op[1]--;
            find(depth + 1, result - arr[depth]);
            op[1]++;
        }
        if (op[2] > 0) { // multiply
            op[2]--;
            find(depth + 1, result * arr[depth]);
            op[2]++;
        }
        if (op[3] > 0) { // divide
            op[3]--;
            find(depth + 1, result / arr[depth]);
            op[3]++;
        }
    }

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < op.length; i++)
            op[i] = Integer.parseInt(st.nextToken());

        // 탐색
        find(1, arr[0]);

        // 출력
        System.out.println(max);
        System.out.println(min);
    }
}
