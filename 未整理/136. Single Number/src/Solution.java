
public class Solution {
	public int singleNumber(int[] nums) {
		int ans = 0;
		for (int x : nums) {
			ans = ans ^ x;
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 3, 2, 2, 4, 4 };
		System.out.println(new Solution().singleNumber(a));
	}

}
