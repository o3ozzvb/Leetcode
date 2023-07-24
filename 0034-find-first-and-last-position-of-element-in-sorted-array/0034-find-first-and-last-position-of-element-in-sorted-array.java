class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] answer = {-1, -1};
        int left = 0;
        int right = nums.length - 1;

        if (nums.length == 1) {
            if (nums[0] == target) {
                answer[0] = 0;
                answer[1] = 0;
            }
        } else {
            while (left <= right) {
                int mid = (left + right) / 2;

                if (nums[mid] == target) {
                    int start = mid;
                    int end = mid;
                    while (start >= 0 && nums[start] == target) {
                        start--;
                    }
                    while (end < nums.length && nums[end] == target) {
                        end++;
                    }
                    answer[0] = start + 1;
                    answer[1] = end - 1;
                    return answer;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                }
            }
        }
        return answer;
    }
}