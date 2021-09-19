public class Prob12937 {
    public String solution(int num) {
        return num % 2 == 0 ? "Even" : "Odd";
    }

    public static void main(String[] args) {
        int num = 3;
        System.out.println(new Prob12937().solution(num));
    }
}