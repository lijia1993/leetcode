public class Solution {
	public boolean canJump(int[] nums) {
		int n = nums.length;
		if(n==1) return true;
    	for(int i=n-1;i>=0;i--){
    		if(nums[i]==0){
    			boolean flags = false;
    			for(int j=i-1;j>=0;j--){
    				if(nums[j]>i-j||(i==n-1&&nums[j]==i-j)){
    					flags=true;
    					i=j;
    				}
    			}
    			if(!flags){
    				return false;
    			}
    		}
    	}
		return true;
    }
}