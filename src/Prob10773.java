import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int[] arr = new int[k];
        int size = 0;
        while (k-- > 0) {
            String num = br.readLine();
            if (num.equals("0"))
                size -= 1; // 0인 경우 최근 것 지우기
            else
                arr[size++] = Integer.parseInt(num); // 추가
        }
        int sum = 0; // 총합
        for (int i = 0; i < size; i++)
            sum += arr[i];
        System.out.println(sum);
    }
}
