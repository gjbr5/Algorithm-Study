import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob9663 {

    private static int find(int[] arr, int depth) {
        if (depth == arr.length)
            return 1;
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[depth] = i;
            for (int j = 0; j < depth; j++) {
                if (arr[depth] == arr[j] || depth - j == Math.abs(arr[depth] - arr[j])) {
                    arr[depth] = -1;
                    break;
                }
            }
            if (arr[depth] != -1)
                cnt += find(arr, depth + 1);
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(find(new int[n], 0));
    }
}
