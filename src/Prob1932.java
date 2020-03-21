import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            if (i > 0) {
                for (int j = 0; j <= i; j++) {
                    if (j == 0)
                        arr[i][j] += arr[i - 1][j];
                    else if (j == i)
                        arr[i][j] += arr[i - 1][j - 1];
                    else
                        arr[i][j] += Math.max(arr[i - 1][j - 1], arr[i - 1][j]);
                }
            }
        }
        int max = -1;
        for (int i = 0; i < n; i++) {
            if (max < arr[n - 1][i])
                max = arr[n - 1][i];
        }
        System.out.println(max);
    }
}
