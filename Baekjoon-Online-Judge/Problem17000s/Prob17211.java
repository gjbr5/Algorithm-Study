package Problem17000s;

import java.util.Scanner;

public class Prob17211 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt() - 1, now = in.nextInt();
        double gg = in.nextDouble(), gb = in.nextDouble(), bg = in.nextDouble(), bb = in.nextDouble();
        double good, bad;

        // 다음날
        if (now == 0) {
            good = gg;
            bad = gb;
        } else {
            good = bg;
            bad = bb;
        }

        // n일 후
        while (n-- > 0) {
            double next_good = good * gg + bad * bg;
            double next_bad = good * gb + bad * bb;
            good = next_good;
            bad = next_bad;
        }
        System.out.println(Math.round(good * 1000));
        System.out.println(Math.round(bad * 1000));
        in.close();
    }
}
