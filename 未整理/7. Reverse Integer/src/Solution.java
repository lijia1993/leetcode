
public class Solution {
	public int reverse(int x) {
		if (x == 0)
			return 0;
		int ans = 0;
		double judgeOverflow = 0;
		int tmp = x;
		while (tmp != 0) {
			judgeOverflow = (double) ans * 10 + tmp % 10;
			if (x>0 && judgeOverflow > 0x7fffffff)
				return 0;
			if (x<0 && judgeOverflow < 0x80000000)
				return 0;
			ans = ans * 10 + tmp % 10;
			tmp /= 10;
		}
		return ans;
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		System.out.println(0x80000000);
		System.out.println(0x80000001);
		System.out.println(0x7fffffff);
		System.out.println(obj.reverse(-123));
	}
}
