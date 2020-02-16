import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob2580 {

    private static int[][] puzzle = new int[9][9];

    private static boolean find() {
        int row = 0, col = 0;
        // 다음 채울 곳 찾기
        for (int i = 0; i <= 81; i++) {
            if (i == 81) // 채울 곳이 없으면 종료
                return true;
            row = i / 9;
            col = i % 9;
            if (puzzle[row][col] == 0) // 채울 곳을 찾음
                break;
        }
        for (int i = 1; i <= 9; i++) { // 1부터 9까지 넣어보기
            puzzle[row][col] = i;
            if (check(row, col) && find()) // 체크해서 이상없으면 다음 빈 칸 채우기
                return true; // 빈 칸 채우기에 성공한 경우
        }
        puzzle[row][col] = 0;
        return false; // 빈 칸 채우기에 실패한 경우
    }

    private static boolean check(int row, int col) {
        // 가로줄 검사
        boolean[] flag = new boolean[10];
        for (int i = 0; i < 9; i++)
            if (i != col)
                flag[puzzle[row][i]] = true;
        if (flag[puzzle[row][col]])
            return false;

        // 세로줄 검사
        flag = new boolean[10];
        for (int i = 0; i < 9; i++)
            if (i != row)
                flag[puzzle[i][col]] = true;
        if (flag[puzzle[row][col]])
            return false;

        // 3x3 블록 검사
        flag = new boolean[10];
        int row_start = row / 3 * 3;
        int col_start = col / 3 * 3;
        for (int i = row_start; i < row_start + 3; i++)
            for (int j = col_start; j < col_start + 3; j++)
                if (i != row || j != col)
                    flag[puzzle[i][j]] = true;
        return !flag[puzzle[row][col]];
    }

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                puzzle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 탐색
        find();

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(puzzle[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
