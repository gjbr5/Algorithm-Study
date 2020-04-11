import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob5086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0) // a와 b가 모두 0이면 종료
                break;
            if (a > b && a % b == 0)
                sb.append("multiple\n"); // a가 b의 배수
            else if (b % a == 0)
                sb.append("factor\n"); // a가 b의 약수
            else
                sb.append("neither\n"); // 둘 다 아님
        }
        System.out.print(sb);
    }
}
