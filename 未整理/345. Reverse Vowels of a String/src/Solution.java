
public class Solution {

	public String reverseVowels(String s) {
		String vowes = "aeiouAEIOU";
		char[] s_char = s.toCharArray();
		int st = 0, ed = s.length() - 1, len = s.length();
		while (st < ed) {
			while (st < len && !vowes.contains(String.valueOf(s_char[st])))
				st++;
			while (ed > 0 && !vowes.contains(String.valueOf(s_char[ed])))
				ed--;
			if (st < ed) {
				char tmp = s_char[st];
				s_char[st] = s_char[ed];
				s_char[ed] = tmp;
			}
			st++;
			ed--;
		}
		return new String(s_char);
	}

	public static void main(String[] args) {
		System.out.println(new Solution().reverseVowels("hello"));
		System.out.println(new Solution().reverseVowels("leetcode"));
		System.out.println(new Solution().reverseVowels(".,"));
	}
}
