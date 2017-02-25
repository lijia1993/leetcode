
public class Solution {

	public int addDigits(int num) {
		return 1+(num-1)%9;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().addDigits(38));
	}

}
