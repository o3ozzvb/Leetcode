class Solution {
    public String longestCommonPrefix(String[] strs) {
        String answer = "";
        char firstLetter;
        boolean flag = true;

        int minLength = Integer.MAX_VALUE;
        for (String s : strs) {
            if (minLength > s.length()) {
                minLength = s.length();
            }
        }

        for (int i = 0; i < minLength; i++) {
            firstLetter = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (firstLetter != strs[j].charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) answer += firstLetter;
            if (!flag) break;
        }
        return answer;
    }
}