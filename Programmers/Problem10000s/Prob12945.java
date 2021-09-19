public class Prob12945 {
    public int solution(int n) {
        int[] fibo = { 0, 1, 1 };
        while (--n > 0) {
            fibo[2] = (fibo[1] + fibo[0]) % 1234567;
            fibo[0] = fibo[1];
            fibo[1] = fibo[2];
        }
        return fibo[2];
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new Prob12945().solution(n));
    }
}
