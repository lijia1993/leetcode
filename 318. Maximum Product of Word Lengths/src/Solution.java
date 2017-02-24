public class Solution {
    public int maxProduct(String[] words) {
    	int ans = 0;
    	int wordsNum = words.length;
    	int[] bits = new int[wordsNum];
    	for(int i=0;i<wordsNum;i++){
    		int len = words[i].length();
    		for(int j=0;j<len;j++){
    			bits[i] |= (1<<(words[i].charAt(j)-'a'));
    		}
    		for(int j=0;j<=i-1;j++){
    			if((bits[i]&bits[j])==0){
    				ans = Math.max(ans, len*words[j].length());
    			}
    		}
    	}
        return ans;
    }
    
    public static void main(String[] args) {
		String[] words = new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
		System.out.println(new Solution().maxProduct(words));
	}
}