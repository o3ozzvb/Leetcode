import java.util.*;
class Solution {
    List<String> combinations = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        String[] alphabets = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> letters = new ArrayList<>();

        if (digits.length() == 0) {
            return letters;
        }

        for (int i=0; i<digits.length(); i++) {
            letters.add(alphabets[digits.charAt(i) - '0']);
        }

        dfs(letters, 0, digits.length(), "");

        return combinations;
    }

    public void dfs(List<String> letters, int idx, int length, String combination) {
        if (idx == length) {
            combinations.add(combination);
            return;
        }

        String letter = letters.get(idx);
        for (int i=0; i<letter.length(); i++) {
            combination += letter.charAt(i);
            dfs(letters, idx+1, length, combination);
            combination = combination.substring(0, idx);
        }
    }
}