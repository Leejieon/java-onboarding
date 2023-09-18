package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 예외 상황에 해당할 경우, 종료
        if (isException(pobi) || isException(crong)) {
            return -1;
        }

        answer = getWinner(pobi, crong);

        return answer;
    }

    public static boolean isException(List<Integer> page) {
        int left = page.get(0);
        int right = page.get(1);

        // 1. 왼쪽 페이지 >= 오른쪽 페이지 인 경우
        if (left >= right) {
            return true;
        }
        // 2. 페이지가 1 이상 400 이하가 아닌 경우
        else if (left < 1 || right > 400) {
            return true;
        }
        // 3. 연속된 페이지가 아닌 경우
        else if (right - left != 1) {
            return true;
        }
        // 4. 왼쪽이 홀수, 오른쪽이 짝수가 아닌 경우
        else if ( (left % 2) != 1 || (right % 2) != 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public static int addDigit(int page) {
        int sum = 0;
        int digit = page;
        while (digit > 0) {
            sum += digit%10;
            digit /= 10;
        }

        return sum;
    }

    public static int multiDigit(int page) {
        int sum = 1;
        int digit = page;
        while (digit > 0) {
            sum *= digit%10;
            digit /= 10;
        }

        return sum;
    }

    public static int getMaxNumber(List<Integer> page) {
        int leftMax = Math.max(addDigit(page.get(0)), multiDigit(page.get(0)));
        int rightMax = Math.max(addDigit(page.get(1)), multiDigit(page.get(1)));

        return Math.max(leftMax, rightMax);
    }

    public static int getWinner(List<Integer> player1, List<Integer> player2) {

        int player1Max = getMaxNumber(player1);
        int player2Max = getMaxNumber(player2);

        if (player1Max == player2Max) {
            return 0;
        } else if (player1Max > player2Max) {
            return 1;
        } else {
            return 2;
        }
    }
}