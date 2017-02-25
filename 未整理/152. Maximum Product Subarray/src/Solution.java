public class Solution {
    public int maxProduct(int[] nums) {
    	int n = nums.length;
    	if(n==0) return 0;
    	int[][] dp = new int[n][2];
    	int ans = nums[0];
    	dp[0][0] = nums[0];
    	dp[0][1] = nums[0];
    	for(int i=1;i<n;i++){
    		int val1 = dp[i-1][0] * nums[i];
    		int val2 = dp[i-1][1] * nums[i];
    		dp[i][0] = Math.min(val1, val2);
    		dp[i][0] = Math.min(dp[i][0], nums[i]);
    		dp[i][1] = Math.max(val1, val2);
    		dp[i][1] = Math.max(dp[i][1], nums[i]);
    		ans = Math.max(ans, dp[i][0]);
    		ans = Math.max(ans, dp[i][1]);
    	}
        return ans;
    }
    
    public static void main(String[] args) {
		int[] nums = new int[]{-2,0,-1};
		System.out.println(new Solution().maxProduct(nums));
	}
}