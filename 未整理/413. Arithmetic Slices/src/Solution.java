public class Solution {
	public int numberOfArithmeticSlices(int[] A) {
		int ALen = A.length;
		int ans = 0;
		if (ALen >= 3) {
			int a1 = A[0];
			int a2 = A[1];
			int dif = a2 - a1;
			int curLen = 2;
			int i = 2;
			while (i < ALen) {
				if (A[i] - A[i - 1] == dif) {
					i++;
					curLen++;
					continue;
				}
				ans += (curLen - 1) * (curLen - 2) / 2;
				a1 = A[i - 1];
				a2 = A[i];
				dif = a2 - a1;
				curLen = 2;
				i++;
			}
			ans += (curLen - 1) * (curLen - 2) / 2;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Solution obj = new Solution();
		int[] A = new int[]{1,2,5,8};
		System.out.println(obj.numberOfArithmeticSlices(A));
	}
}