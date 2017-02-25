
public class Solution {
	public int firstUniqChar(String s) {
		int ans = -1;
		int[] hashTable = new int[26];
		int s_len = s.length();
		for (int i = 0; i < s_len; i++) {
			hashTable[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < s_len; i++) {
			if (hashTable[s.charAt(i)-'A'] == 1)
				return i;
		}
		return ans;
	}
}
