package Problem01000s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob1000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        System.out.println(Integer.parseInt(s[0]) + Integer.parseInt(s[1]));
    }

}
