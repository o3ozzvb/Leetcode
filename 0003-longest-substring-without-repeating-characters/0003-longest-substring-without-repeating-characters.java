class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        String substr = s.substring(0, 1);
        int maxLen = 1;

        for (int i = 1; i < s.length(); i++) {
            int idx = substr.indexOf(s.charAt(i));
            if (idx < 0) {
                substr += s.charAt(i);
            } else {
                substr = substr.substring(idx + 1);
                substr += s.substring(i, i + 1);
            }
            maxLen = maxLen > substr.length() ? maxLen : substr.length();
        }
        return maxLen;
    }
}