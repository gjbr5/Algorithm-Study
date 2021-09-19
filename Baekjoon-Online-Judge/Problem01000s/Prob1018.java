package Problem01000s;

import java.util.Scanner;

public class Prob1018 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        in.nextLine(); // '\n' 처리
        String[] board = new String[n];
        for (int i = 0; i < n; i++) {
            board[i] = in.nextLine();
        }

        int min = 65; // 최댓값 : 8 * 8 = 64
        // 체스판 자르기
        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                int cnt = 0;
                // 다시 칠해야 할 것들 카운트(맨 왼쪽 위 칸이 검은색인 경우 기준)
                for (int r = i; r < i + 8; r++) {
                    for (int c = j; c < j + 8; c++) {
                        if ((r + c - i - j) % 2 == 0) {
                            if (board[r].charAt(c) == 'W')
                                cnt++;
                        } else {
                            if (board[r].charAt(c) == 'B')
                                cnt++;
                        }
                    }
                }
                // 맨 왼쪽 위 칸이 흰색일 경우 다시 칠해야 할 갯수 = 64 - cnt
                cnt = Math.min(64 - cnt, cnt);
                if (cnt < min)
                    min = cnt;
            }
        }
        System.out.println(min);
        in.close();
    }
}
