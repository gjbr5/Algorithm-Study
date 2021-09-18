import java.util.Calendar;

class Prob12901 {
    public String solution(int a, int b) {
        String[] answer = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
        Calendar cal = Calendar.getInstance();
        cal.set(2016, a - 1, b);
        return answer[cal.get(Calendar.DAY_OF_WEEK) - 1];
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 24;
        System.out.println(new Prob12901().solution(a, b));
    }
}