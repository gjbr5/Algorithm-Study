import java.util.Scanner;

public class Prob1712 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt(), b = in.nextInt(), c = in.nextInt();

        if (b >= c) // B >= C일 경우 손익분기점이 없음
            System.out.println(-1);
        else // 공식에 대입
            System.out.println(a / (c - b) + 1);
    }
}
