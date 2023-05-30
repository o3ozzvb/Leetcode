class Solution {
    public int reverse(int x) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        long answer = 0;
        boolean flagMinus = false;

        if (x < 0) {
            flagMinus = true;
            x *= -1;
        }

        while (x > 0) {
            answer *= 10;
            answer += x % 10;
            x = x / 10;
        }

        if (flagMinus) {
            answer *= -1;
        }

        if  (answer > max || answer < min) {
                return 0;
        }

        return Long.valueOf(answer).intValue();
    }
}