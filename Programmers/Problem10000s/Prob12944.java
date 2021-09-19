public class Prob12944 {
    public double solution(int[] arr) {
        double sum = 0;
        for (int x : arr)
            sum += x;
        return sum / arr.length;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        System.out.println(new Prob12944().solution(arr));
    }
}
