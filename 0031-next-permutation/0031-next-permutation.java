class Solution {
    public void nextPermutation(int[] nums) {
        boolean lastP = true;
        List<Integer> list = new LinkedList<>();

        for (int i = nums.length - 1; i > 0; i--) {
            list.add(nums[i]);

            if (nums[i - 1] < nums[i]) {
                lastP = false;

                list.sort(Comparator.naturalOrder());

                for (int j = 0; j < list.size(); j++) {
                    if (nums[i - 1] < list.get(j)) {
                        int x = list.get(j);
                        list.remove(j);
                        list.add(nums[i - 1]);
                        nums[i - 1] = x;
                        break;
                    }
                }

                list.sort(Comparator.naturalOrder());
                for (int j = 0; j < list.size(); j++) {
                    nums[i + j] = list.get(j);
                }

                return;
            }
        }
        if (lastP) {
            Arrays.sort(nums);
        }
    }
}