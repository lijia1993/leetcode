import java.util.Arrays;

public class Solution {
    public int minMoves(int[] nums) {
    	if(nums.length==0) return 0;
    	Arrays.sort(nums);
    	int ans = 0,len = nums.length;
    	for(int i=1;i<len;i++){
    		ans+=(nums[i]-nums[0]);
    	}
        return ans;
    }
}