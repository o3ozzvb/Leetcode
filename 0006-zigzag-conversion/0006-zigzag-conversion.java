class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        List<String> list = new ArrayList<>(4);
        int idx = 0;
        int dr = 1; // 1: 아래, -1 : 위
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            list.add("");
        }

        for (int i = 0; i < s.length(); i++) {
            list.set(idx, list.get(idx) + s.charAt(i));

            if (idx + dr < 0 || idx + dr >= numRows) {
                dr *= -1;
            }
            idx = idx + dr;
        }

        for (int i = 0; i < numRows; i++) {
            answer.append(list.get(i));
        }
        return answer.toString();
    }
}