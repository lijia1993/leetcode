public class Solution {
    public int singleNumber(int[] nums) {
    	int result = 0;
    	for(int i=0;i<32;i++){
    		int count=0;
    		for(int num:nums){
    			count += ((num>>i) & 1);
    		}
    		result |= ((count%3) << i);
    	}
        return result;
    }
}