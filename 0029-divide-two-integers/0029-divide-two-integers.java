class Solution {
    public int divide(int dividend, int divisor) {
        int answer;if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE; //overflow case
         
        boolean negative = dividend < 0 ^ divisor < 0; //if the results is negative only if any one of them is negative
        
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int quotient = 0, subQuot = 0;
        
        while (dividend - divisor >= 0) {
            for (subQuot = 0; dividend - (divisor << subQuot << 1) >= 0; subQuot++);
            quotient += 1 << subQuot; //Add to the quotient
            dividend -= divisor << subQuot; //Substract from dividend to start over with the remaining
        }
        return negative ? -quotient : quotient;    }
}