import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob5543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int burger = Integer.parseInt(br.readLine());
        burger = Math.min(burger, Integer.parseInt(br.readLine()));
        burger = Math.min(burger, Integer.parseInt(br.readLine()));
        int beverage = Integer.parseInt(br.readLine());
        beverage = Math.min(beverage, Integer.parseInt(br.readLine()));
        System.out.println(burger + beverage - 50);
    }
}
