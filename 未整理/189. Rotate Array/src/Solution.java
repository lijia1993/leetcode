public class Solution {
    public void rotate(int[] nums, int k) {
        int len=nums.length;
        if(len<k) k = k%len;
        for(int i=1;i<=k;i++){
        	int last = nums[len-1];
        	for(int j=len-1;j>0;j--){
        		nums[j] = nums[j-1];
        	}
        	nums[0] = last;
        }
        for(int num:nums){
        	System.out.println(num);
        }
    }
    public static void main(String[] args) {
    	int[] nums = new int[]{1,2,3};
		new Solution().rotate(nums, 2);
	}
}