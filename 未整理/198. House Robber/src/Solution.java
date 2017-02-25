public class Solution {
	public int rob(int[] nums) {
		if (nums.length == 0)
			return 0;
		int ans = 0, len = nums.length;
		int[][] f = new int[nums.length][2];
		for (int i = 0; i < len; i++) {
			if (i == 0) {
				f[i][0] = 0;
				f[i][1] = nums[i];
				ans = Math.max(f[i][1], ans);
				continue;
			}
			f[i][0] = Math.max(f[i - 1][0], f[i - 1][1]);
			f[i][1] = f[i - 1][0] + nums[i];
			ans = Math.max(f[i][0], ans);
			ans = Math.max(f[i][1], ans);
		}
		return ans;
	}
}