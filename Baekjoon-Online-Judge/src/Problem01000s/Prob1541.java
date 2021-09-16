package Problem01000s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer terms = new StringTokenizer(br.readLine(), "-");

        // 첫 '-' 전까지
        int min = 0;
        StringTokenizer term = new StringTokenizer(terms.nextToken(), "+");
        while (term.hasMoreTokens()) {
            min += Integer.parseInt(term.nextToken());
        }

        while (terms.hasMoreTokens()) {
            // - (a + b + ...)
            term = new StringTokenizer(terms.nextToken(), "+");
            int n = 0;
            while (term.hasMoreTokens()) {
                n += Integer.parseInt(term.nextToken());
            }
            min -= n;
        }
        System.out.println(min);
    }
}
