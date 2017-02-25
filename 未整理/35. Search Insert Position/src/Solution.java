public class Solution {
	public int searchInsert(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		int ans = -1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if(nums[mid]==target){
				ans = mid;
				break;
			}
			if(nums[mid]<target){
				left = mid + 1;
			}
			else{
				right = mid - 1;
			}
		}
		if(ans==-1){
			ans = right;
		}
		return ans;
	}
}