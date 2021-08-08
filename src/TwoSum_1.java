
public class TwoSum_1 {

	public static int[] twoSum(int[] nums, int target) {
		
		int len = nums.length;
		int[] ans = new int[2];
		
		for(int i = 0; i < len; i++) {
			for(int j = i+1; j < len; j++) {
				if(nums[i]+ nums[j] == target) {
					ans[0] = i;
					ans[1] = j;
					break;
				}
			}
		}
		
		return ans;

	}
	
	public static void main(String[] args) {
		int[] nums = {3,3};
		int target = 6;
		
		int[] ans = twoSum(nums, target);
		
		for(int i : ans)
			System.out.println(i);

	}

}
