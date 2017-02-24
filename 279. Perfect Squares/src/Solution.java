public class Solution {
    public int numSquares(int n) {
    	int sqrtn = (int) Math.sqrt(n);
    	int[] dp = new int[n+1];
    	for(int i=1;i<=n;i++){
    		dp[i] = i;
    		for(int j=1;j<=sqrtn;j++){
    			if(i<j*j){
    				break;
    			}
    			if(i==j*j){
    				dp[i] = 1;
    				continue;
    			}
    			dp[i] = Math.min(dp[i], dp[i-j*j]+1);
    		}
    	}
        return dp[n];
    }
}