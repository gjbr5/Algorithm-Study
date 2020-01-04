import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob2231 {

    public static void main(String[] args) throws IOException {
        // 분해합 미리 구해놓기
        int[] generator = new int[1000001];
        for (int g = 0; g <= 1000000; g++) {
            int sum = g; // sum : 분해합
            for (int i = g; i != 0; i /= 10)
                sum += i % 10;

            // 기존의 생성자가 없으면 i는 가장 작은 생성자
            if (sum <= 1000000 && generator[sum] == 0)
                generator[sum] = g;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 읽어서
        System.out.println(generator[n]); // 생성자 출력
    }
}
