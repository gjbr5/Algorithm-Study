package Problem05000s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob5543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 가장 싼 햄버거
        int burger = Integer.parseInt(br.readLine());
        burger = Math.min(burger, Integer.parseInt(br.readLine()));
        burger = Math.min(burger, Integer.parseInt(br.readLine()));
        // 가장 싼 음료
        int beverage = Integer.parseInt(br.readLine());
        beverage = Math.min(beverage, Integer.parseInt(br.readLine()));

        // 세트메뉴 가격 = 버거 + 음료 - 50
        System.out.println(burger + beverage - 50);
    }
}
