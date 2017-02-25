public class Solution {
    public int wiggleMaxLength(int[] nums) {
    	int len = nums.length;
    	if(len==0) return 0;
    	int ans = 1;
    	int pre = nums[0];
    	for(int i=1;i<len;i++){
    		boolean flags = false;
    		if(i<len-1&&((nums[i]>pre&&nums[i]<nums[i+1])||
    				(nums[i]<pre&&nums[i]>nums[i+1])||(nums[i]==nums[i+1]))){
    			flags = true;
    		}
    		if(nums[i]==pre||flags){
    			continue;
    		}
    		pre = nums[i];
    		ans++;
    	}
        return ans;
    }
    
    public static void main(String[] args) {
		int[] nums = new int[]{1,5,5,5,6};
		System.out.println(new Solution().wiggleMaxLength(nums));
	}
}