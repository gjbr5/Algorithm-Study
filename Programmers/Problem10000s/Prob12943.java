public class Prob12943 {
    public int solution(int num) {
        for (int i = 0; i < 500; i++) {
            if (num == 1)
                return i;
            else if (num % 2 == 0)
                num /= 2;
            else
                num = num * 3 + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int num = 6;
        System.out.println(new Prob12943().solution(num));
    }
}
