class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int answer = 0;
        int j = 0, k = 0, sum = 0;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            j = i + 1;
            k = nums.length - 1;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum - target) < diff) {
                    diff = Math.abs(sum - target);
                    answer = sum;
                }

                if (sum <= target) {
                    j++;
                }
                if (sum >= target) {
                    k--;
                }
            }
        }

        return answer;
    }
}