package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    static String findDuplicateChar(String cryptogram) {
        for (int start = 0; start < cryptogram.length() - 1; start++) {
            boolean isDuplicate = false;
            for (int end = start + 1; end < cryptogram.length(); end++) {
                if (cryptogram.charAt(start) == cryptogram.charAt(end)) {
                    isDuplicate = true;

                    // end index 가 문자열 마지막에 도달했을 경우.
                    if (end == cryptogram.length() - 1) {
                        // TODO : 중복 문자 제거 메서드 추가
                        cryptogram = removeDuplicateChar(cryptogram, start, end + 1);
                    }
                }
                else {
                    if (isDuplicate) {
                        // TODO : 중복 문자 제거 메서드 추가
                        cryptogram = removeDuplicateChar(cryptogram, start, end);
                        start -= 1;
                    }
                    break;
                }
            }
        }

        return cryptogram;
    }

    static String removeDuplicateChar(String cryptogram, int start, int end) {
        StringBuilder sb = new StringBuilder(cryptogram);

        // 해당 start ~ end 위치 문자열 삭제
        for (int i = start; start < end; start++) {
            sb.deleteCharAt(i);
        }

        return sb.toString();
    }
}
