import java.util.Scanner;

public class Prob1018 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        in.nextLine();
        String[] board = new String[n];
        for (int i = 0; i < n; i++) {
            board[i] = in.nextLine();
        }

        int min = 65;
        outer:
        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                int wCnt = 0, bCnt = 0;
                for (int r = i; r < i + 7; r++) {
                    for (int c = j; c < j + 7; c++) {
                        System.out.print(board[r].charAt(c));
                        if ((r + c - i - j) % 2 == 0) {
                            if (board[r].charAt(c) == 'W')
                                bCnt++;
                            else
                                wCnt++;
                        } else {
                            if (board[r].charAt(c) == 'B')
                                wCnt++;
                            else
                                bCnt++;
                        }
                    }
                    System.out.println();
                }
                if (min > wCnt)
                    min = wCnt;
                if (min > bCnt)
                    min = bCnt;
                if (min == 0)
                    break outer;
            }
        }
        System.out.println(min);
    }
}
