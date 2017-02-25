public class Solution {
    public int[] productExceptSelf(int[] nums) {
    	int len = nums.length;
        int[] result = new int[len];
        if(len<=1) return result;
        int[] res = new int[len];
        for(int i=0;i<len;i++){
        	if(i==0){
        		res[0] = nums[i];
        		continue;
        	}
        	res[i] = res[i-1] * nums[i];
        }
        int[] res_rev = new int[len];
        for(int i=len-1;i>=0;i--){
        	if(i==len-1){
        		res_rev[i] = 1;
        		result[i] = res[i-1] * res_rev[i];
        		continue;
        	}
        	if(i==0){
        		res_rev[i] = res_rev[i+1] * nums[i+1];
        		result[i] = res_rev[i];
        		break;
        	}
        	res_rev[i] = res_rev[i+1] * nums[i+1];
        	result[i] = res_rev[i] * res[i-1];
        }
        return result;
    }
    
    public static void main(String[] args) {
		Solution obj = new Solution();
		int[] nums = new int[]{4,3,2,1,2};
		obj.productExceptSelf(nums);
	}
}