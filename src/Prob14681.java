import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob14681 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        if (x > 0) {
            if (y > 0)
                System.out.println(1); // 둘 다 양수 -> 1사분면
            else
                System.out.println(4); // y만 음수 -> 4사분면
        } else {
            if (y > 0)
                System.out.println(2); // x만 음수 -> 2사분면
            else
                System.out.println(3); // 둘 다 음수 -> 3사분면
        }
    }
}
