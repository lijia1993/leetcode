
public class Solution {
	public char findTheDifference(String s, String t) {
		int[] hash = new int[26];
		int len = s.length();
		for(int i=0;i<len;i++){
			hash[t.charAt(i)-'a']++;
			hash[s.charAt(i)-'a']--;
		}
		hash[t.charAt(len)-'a']++;
		for(int i=0;i<26;i++){
			if(hash[i]==1) return (char) ('a'+i);
		}
		return t.charAt(0);
	}

	public static void main(String[] args) {
		System.out.println(new Solution().findTheDifference("abcd", "abcde"));
	}

}
