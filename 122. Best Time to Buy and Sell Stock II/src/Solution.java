public class Solution {
    public int maxProfit(int[] prices) {
    	if(prices.length==0) return 0;
    	int n = prices.length;
    	int ans = 0;
    	int start = prices[0];
    	for(int i=1;i<n;i++){
    		if(prices[i]<prices[i-1]){
    			ans+=prices[i-1]-start;
    			start = prices[i];
    		}
    	}
    	ans += prices[n-1]-start;
        return ans;
    }
    
    public static void main(String[] args) {
		int[] prices = new int[]{7, 1, 5, 3, 6, 4};
		System.out.println(new Solution().maxProfit(prices));
	}
}