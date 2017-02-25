public class Solution {
    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        int mix = 0;
        for(int num:nums){
        	mix ^= num;
        }
        mix &= -mix;
        for(int num:nums){
        	if((mix & num) == 0) result[0] ^=num;
        	else result[1] ^=num;
        }
        return result;
    }
}