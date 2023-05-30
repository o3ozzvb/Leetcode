class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }

        String answer = s.substring(0, 1);
        for (int i = s.length(); i >= 1 ; i--) {
            for (int j = 0; j <= s.length() - i; j++) {
                String substring = s.substring(j, j + i);
                if (isPalindrome(substring)) {
                    return substring;
                }
            }
        }

        return answer;
    }
    
    public boolean isPalindrome(String sub) {
        int mid = sub.length() / 2;
        int lastIdx = sub.length() - 1;

        for (int i = 0; i < mid; i++) {
            if (sub.charAt(i) != sub.charAt(lastIdx - i)) {
                return false;
            }
        }
        return true;
    }
}