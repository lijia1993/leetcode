
public class Solution {

	public String reverseString(String s) {
		return new StringBuilder(s).reverse().toString();
	}

	public static void main(String[] args) {
		new Solution().reverseString("hello");
	}
}
