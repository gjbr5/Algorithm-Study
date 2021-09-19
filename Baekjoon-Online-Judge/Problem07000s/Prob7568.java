package Problem07000s;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Prob7568 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        // <몸무게, 키> 배열
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(Map.entry(in.nextInt(), in.nextInt()));

        // 모든 경우 비교
        for (int i = 0; i < n; i++) {
            int cnt = 1; // 1등부터 시작
            for (int j = 0; j < n; j++) {
                // 자기 자신과의 비교는 필요 없음
                if (i == j)
                    continue;
                // 몸무게와 키 둘 다 작을 경우 등수 하락
                if (list.get(i).getKey() < list.get(j).getKey() && list.get(i).getValue() < list.get(j).getValue())
                    cnt++;
            }
            System.out.println(cnt);
        }
        in.close();
    }
}
