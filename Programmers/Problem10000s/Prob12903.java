class Prob12903 {
    public String solution(String s) {
        int mid = s.length() / 2;
        if (s.length() % 2 == 0)
            return s.substring(mid - 1, mid + 1);
        return s.substring(mid, mid + 1);
    }

    public static void main(String[] args) {
        String s = "abcxde";
        System.out.println(new Prob12903().solution(s));
    }
}