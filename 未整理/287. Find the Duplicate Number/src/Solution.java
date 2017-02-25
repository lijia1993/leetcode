public class Solution {
    public int findDuplicate(int[] nums) {
    	int len = nums.length;
    	for(int i=0;i<len;i++){
    		for(int j=0;j<len;j++){
    			if(i!=j&&nums[i]==nums[j]){
    				return nums[i];
    			}
    		}
    	}
        return 0;
    }
}