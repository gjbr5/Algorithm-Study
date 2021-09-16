package Problem10000s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Prob10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<UserInfo> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new UserInfo(st.nextToken(), st.nextToken()));
        }

        // 정렬 : Collections(ArrayList 등)의 sort 메소드는 Stable Sort!!
        list.sort(Comparator.comparingInt(value -> value.age));

        for (UserInfo item : list) {
            System.out.println(item);
        }
    }

    // 사용자 정보 클래스
    private static class UserInfo {
        int age;
        String name;

        public UserInfo(String age, String name) {
            this.age = Integer.parseInt(age);
            this.name = name;
        }

        @Override
        public String toString() {
            return age + " " + name;
        }
    }
}
