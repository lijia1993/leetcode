public class Solution {
    public int numDecodings(String s) {
    	int len = s.length();
    	if(len==0 || s.charAt(0)=='0') return 0;
    	int[] dp = new int[len+1];
    	dp[0] = 1;
    	dp[1] = 1;
    	for(int i=2;i<=len;i++){
    		int num = s.charAt(i-1)-'0';
    		int withPreNum = (s.charAt(i-2)-'0')*10+num;
    		if(num>0){
    			dp[i] = dp[i] + dp[i-1];
    		}
    		if(withPreNum>9&&withPreNum<27){
    			dp[i] = dp[i] + dp[i-2];
    		}
    		if(dp[i]==0) return 0;
    	}
        return dp[len];
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().numDecodings("12087102"));
	}
}