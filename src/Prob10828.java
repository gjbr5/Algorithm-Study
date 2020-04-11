import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stack = new int[n];
        int size = 0;
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            String cmd = br.readLine();
            switch (cmd.charAt(0)) {
                case 'p':
                    if (cmd.charAt(1) == 'u') // push
                        stack[size++] = Integer.parseInt(cmd.split(" ")[1]);
                    else if (size == 0) // pop but empty
                        sb.append("-1\n");
                    else // pop
                        sb.append(stack[--size]).append('\n');
                    break;
                case 's': // size
                    sb.append(size).append('\n');
                    break;
                case 'e': // empty
                    if (size == 0)
                        sb.append("1\n");
                    else
                        sb.append("0\n");
                    break;
                case 't': // top
                    if (size == 0)
                        sb.append("-1\n");
                    else
                        sb.append(stack[size - 1]).append('\n');
                    break;
            }
        }
        System.out.print(sb);
    }
}
