
public class Solution {
	public boolean canWinNim(int n) {
		return n%4!=0;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().canWinNim(1));
	}

}
