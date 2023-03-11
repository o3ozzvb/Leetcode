class Solution {
    public int myAtoi(String s) {
       long answer = 0;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        int sign = 1;

        int i = 0;
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                break;
            }
        }
        if (i >= 0 && i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }
        char ch;
        for(; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                answer *= 10;
                answer += ch - '0';

                if (answer * sign < min) {
                    answer = min;
                    break;
                }
                if (answer * sign > max) {
                    answer = max;
                    break;
                }
            }
            else {
                break;
            }
        }

        answer *= sign;

        return Long.valueOf(answer).intValue();
    }
}