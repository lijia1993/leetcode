import java.util.Arrays;

public class Solution {
    public int minMoves2(int[] nums) {
    	Arrays.sort(nums);
        int len = nums.length;
        int avg = (int) ((nums[len/2]+nums[(len-1)/2])/2);
        int ans = 0;
        for(int num:nums){
        	ans+= Math.abs(num-avg);
        }
    	return ans;
    }
}