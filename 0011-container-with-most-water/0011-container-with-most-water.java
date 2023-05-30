class Solution {
    public int maxArea(int[] height) {
        int h = 0;
        int answer = 0, area = 0;

        for (int i = 0; i < height.length - 1; i++) {
            if (height[i] * (height.length - i) < answer) continue;

            for (int j = i + 1; j < height.length; j++) {
                h = height[i] <= height[j] ? height[i] : height[j];
                area = h * (j - i);
                answer = answer > area ? answer : area;
            }
        }

        return answer;
    }
}