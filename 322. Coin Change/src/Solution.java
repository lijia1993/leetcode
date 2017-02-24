import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
    	Arrays.sort(coins);
    	int lenCoins = coins.length;
    	int[] dp = new int[amount+1];
    	for(int i=1;i<=amount;i++){
    		dp[i] = -1;
    		for(int j=0;j<lenCoins;j++){
    			if(i==coins[j]){
    				dp[i]=1;
    				break;
    			}
    			if(i<coins[j]){
    				break;
    			}
    			if(dp[i-coins[j]]!=-1){
    				if(dp[i]==-1){
    					dp[i] = dp[i-coins[j]]+1;
    					continue;
    				}
    				dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
    			}
    		}
    	}
        return dp[amount];
    }
    
    public static void main(String[] args) {
		int[] coins = new int[]{370,417,408,156,143,434,168,83,177,280,117};
		System.out.println(new Solution().coinChange(coins, 9953));
	}
}