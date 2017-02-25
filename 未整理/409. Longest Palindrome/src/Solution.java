public class Solution {
    public int longestPalindrome(String s) {
    	int[] hashNum = new int[52];
    	int len = s.length();
    	for(int i=0;i<len;i++){
    		char c = s.charAt(i);
    		if(c>='a'&&c<='z'){
    			hashNum[c-'a'+26]++;
    		}
    		if(c>='A'&&c<='Z'){
    			hashNum[c-'A']++;
    		}
    	}
    	boolean flags = false;
    	int ans =0;
    	for(int i=0;i<52;i++){
    		if(hashNum[i]%2==1) flags = true;
    		ans += hashNum[i]/2*2;
    	}
    	if(flags) ans++;
        return ans;
    }
    
    public static void main(String[] args) {
		Solution obj = new Solution();
		System.out.println(obj.longestPalindrome("ABCDBCDA"));
	}
}