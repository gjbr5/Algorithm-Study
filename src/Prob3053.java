import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob3053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int r = Integer.parseInt(br.readLine());
        // 유클리드 기하학의 원의 넓이 = pi*r*r
        System.out.println(r * r * Math.PI);
        // 택시 기하학의 원의 넓이 = 유클리드 기하학의 마름모(정사각형) 넓이 = (2r*2r)/2 = 2r*r
        System.out.println(r * r * 2);
    }
}
