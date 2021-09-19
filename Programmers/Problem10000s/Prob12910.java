import java.util.Arrays;

public class Prob12910 {
    public int[] solution(int[] array, int divisor) {
        int[] answer = Arrays.stream(array).filter(n -> n % divisor == 0).sorted().toArray();
        return answer.length == 0 ? new int[] { -1 } : answer;
    }

    public static void main(String[] args) {
        int[] array = { 5, 9, 7, 10 };
        int divisor = 5;
        System.out.println(Arrays.toString(new Prob12910().solution(array, divisor)));
    }
}
