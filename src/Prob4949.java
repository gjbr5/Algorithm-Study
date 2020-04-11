import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Prob4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        nextLine:
        while (true) {
            char[] str = br.readLine().toCharArray();
            if (str[0] == '.') // 종료조건
                break;
            Stack<Character> stack = new Stack<>();
            for (char c : str) {
                if (c == '(' || c == '[') {
                    stack.push(c); // 여는 괄호는 추가
                } else if (c == ')') { // 닫는 소괄호는
                    if (stack.isEmpty() || stack.pop() != '(') {
                        sb.append("no\n"); // 여는 소괄호가 들어있지 않으면 no
                        continue nextLine;
                    }
                } else if (c == ']') { // 닫는 대괄호는
                    if (stack.isEmpty() || stack.pop() != '[') {
                        sb.append("no\n"); // 여는 대괄호가 들어있지 않으면 no
                        continue nextLine;
                    }
                }
            }
            if (stack.isEmpty()) // 최종적으로 스택이 비어있어야 yes
                sb.append("yes\n");
            else
                sb.append("no\n");
        }
        System.out.print(sb);
    }
}
