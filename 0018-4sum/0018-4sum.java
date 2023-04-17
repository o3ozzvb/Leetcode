class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        Set<List<Integer>> set = new HashSet<>();

        Arrays.sort(nums);

        long sum = 0;
        int k = 0, l = 0;
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                k = j + 1;
                l = nums.length - 1;
                while (k < l) {
                    sum = (long)nums[i] + (long)nums[j] + (long)nums[k] + (long)nums[l];
                    if (sum < target) {
                        k++;
                    }
                    if (sum > target) {
                        l--;
                    }
                    if (Long.compare(sum, target) == 0) {
                        set.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
}