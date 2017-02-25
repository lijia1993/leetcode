public class Solution {
    public int climbStairs(int n) {
    	if(n<=1) return n;
        int prep2 = 1;
        int prep1 = 1;
        int ans = 0;
        for(int i=2;i<=n;i++){
        	ans = prep1 +prep2;
        	prep2 = prep1;
        	prep1 = ans;
        }
        return ans;
    }
}