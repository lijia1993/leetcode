
public class Solution {
	public boolean isAnagram(String s, String t) {
		int[] hashTable = new int[26];
		int s_len = s.length();
		int t_len = t.length();
		for(int i=0;i<s_len;i++){
			hashTable[s.charAt(i)-'a']++;
		}
		for(int i=0;i<t_len;i++){
			hashTable[t.charAt(i)-'a']--;
		}
		for(int i=0;i<26;i++){
			if(hashTable[i]!=0) return false;
		}
		return true;
	}

	public static void main(String[] args) {

	}

}
