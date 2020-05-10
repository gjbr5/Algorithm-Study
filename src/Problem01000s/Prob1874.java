package Problem01000s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Prob1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int nums = 0;
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            while (x > nums) { // x가 아직 스택에 들어가지 않았으면
                sb.append("+\n");
                stack.add(++nums); // x를 스택에 넣음
            }
            int y = stack.pop();
            if (x != y) { // 스택 맨 위 값과 현재 수가 맞지 않으면
                System.out.println("NO"); // 만들 수 없는 수열
                return;
            }
            sb.append("-\n"); // 맨 위 값을 스택에서 제거
        }
        System.out.println(sb); // 결과 출력
    }
}
