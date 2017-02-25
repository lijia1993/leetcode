public class Solution {
	// 主元素问题

	public int majorityElement(int[] nums) {
		int len = nums.length;
		if(len==0) return 0;
		int candidate = nums[0];
		int ntimes = 1;
		for(int i=1;i<len;i++){
			if(ntimes==0){
				candidate = nums[i];
				ntimes=1;
			}
			else{
				if(candidate==nums[i]){
					ntimes++;
				}
				else{
					ntimes--;
				}
			}
		}
		
		return candidate;
	}

}
