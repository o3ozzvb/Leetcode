class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> answers = new HashSet<>();

        Arrays.sort(nums);

        int j = 0, k = 0, sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            j = i + 1;
            k = nums.length - 1;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    answers.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }
                else if (sum < 0) {
                    j++;
                }
                else if (sum > 0) {
                    k--;
                }
            }
        }

        return new ArrayList<>(answers);
    }
}