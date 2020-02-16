import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob15652 {

    private static int n, m;
    private static StringBuilder sb = new StringBuilder();

    private static void find(int[] arr, int depth) {
        if (arr.length == depth) {
            append(arr);
            return;
        }
        for (int i = depth == 0 ? 1 : arr[depth - 1]; i <= n; i++) {
            arr[depth] = i;
            find(arr, depth + 1);
        }
    }


    private static void append(int[] arr) {
        for (int value : arr)
            sb.append(value).append(' ');
        sb.append('\n');
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        find(new int[m], 0);
        System.out.println(sb);
    }
}
