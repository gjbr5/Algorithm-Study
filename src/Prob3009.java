import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Prob3009 {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        char[] input = new char[100];
        int len = isr.read(input, 0, input.length);
        isr.close();
        StringTokenizer st = new StringTokenizer(String.valueOf(input, 0, len), " \r\n");
        // 각 점의 좌표 입력
        String[][] point = new String[3][2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                point[i][j] = st.nextToken();
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // x좌표 출력
        if (point[0][0].equals(point[1][0])) {
            bw.write(point[2][0]);
        } else if (point[0][0].equals(point[2][0])) {
            bw.write(point[1][0]);
        } else {
            bw.write(point[0][0]);
        }
        bw.write(" ");
        // y좌표 출력
        if (point[0][1].equals(point[1][1])) {
            bw.write(point[2][1]);
        } else if (point[0][1].equals(point[2][1])) {
            bw.write(point[1][1]);
        } else {
            bw.write(point[0][1]);
        }
        bw.flush();
        bw.close();
    }
}
