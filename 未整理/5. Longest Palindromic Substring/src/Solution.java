public class Solution {
    public String longestPalindrome(String s) {
    	int len = s.length();
    	if(len==0) return "";
    	int ans = 1;
    	String result = ""+s.charAt(0);
    	for(int i=0;i<len;i++){
    		for(int j=len-1;j>i;j--){
    			if(j-i+1<=ans){
    				break;
    			}
    			if(s.charAt(j)==s.charAt(i)){
    				boolean flags = true;
    				int left = i;
    				int right = j;
    				while(left<right){
    					if(s.charAt(left)!=s.charAt(right)){
    						flags = false;
    						break;
    					}
    					left++;
    					right--;
    				}
    				if(flags){
    					if(j-i+1>ans){
    						ans = j-i+1;
    						result = s.substring(i, j+1);
    					}
    					break;
    				}
    			}
    		}
    	}
        return result;
    }
    
    public static void main(String[] args) {
		String s = "cbbd";
		System.out.println(new Solution().longestPalindrome(s));
	}
}