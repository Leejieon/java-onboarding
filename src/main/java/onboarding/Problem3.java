package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = countClap(number);
        return answer;
    }

    public static int count369(int number) {
        int count = 0;
        while (number > 0) {
            int digit = number % 10;
            if (digit == 3 || digit == 6 || digit == 9) {
                count++;
            }
            number /= 10;
        }

        return count;
    }

    public static int countClap(int number) {
        int clap = 0;

        for (int i = 1; i <= number; i++) {
            clap += count369(i);
        }

        return clap;
    }
}
