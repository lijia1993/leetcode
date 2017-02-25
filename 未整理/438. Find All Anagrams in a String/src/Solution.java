import java.util.ArrayList;
import java.util.List;

public class Solution {
	public boolean isValid(String a,String b){
		int[] hashTable = new int[26];
		int len = a.length();
		for(int i=0;i<len;i++){
			hashTable[a.charAt(i)-'a']++;
			hashTable[b.charAt(i)-'a']--;
		}
		for(int i=0;i<26;i++){
			if(hashTable[i]!=0) return false;
		}
		return true;
	}
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<Integer>();
        int sLen = s.length();
        int pLen = p.length();
        if(sLen>=pLen){
        	for(int i=0;i<=sLen-pLen;i++){
        		if(isValid(s.substring(i, i+pLen),p)){
        			ans.add(i);
        		}
        	}
        }
        return ans;
    }
    
    public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";
		new Solution().findAnagrams(s, p);
	}
}