public class Prob81301 {
    public int solution(String s) {
        s = s.replaceAll("one", "1");
        s = s.replaceAll("two", "2");
        s = s.replaceAll("three", "3");
        s = s.replaceAll("four", "4");
        s = s.replaceAll("five", "5");
        s = s.replaceAll("six", "6");
        s = s.replaceAll("seven", "7");
        s = s.replaceAll("eight", "8");
        s = s.replaceAll("nine", "9");
        s = s.replaceAll("zero", "0");
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        String s = "one4seveneight";
        System.out.println(new Prob81301().solution(s));
    }
}