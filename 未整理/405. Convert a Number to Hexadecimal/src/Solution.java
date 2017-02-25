
public class Solution {
	public String toHex(int num) {
		if (num == 0)
			return "0";
		int[] minus = new int[9];
		int minus_len = -1;
		char[] letter = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
		StringBuilder sb = new StringBuilder();
		long tmp = Math.abs((long)num);
		while (tmp > 0) {
			sb.append(letter[(int)tmp % 16]);
			minus_len++;
			minus[minus_len] = (int) tmp % 16;
			tmp /= 16;
		}
		if (num > 0)
			return sb.reverse().toString();
		int[] sum = { 0, 0, 0, 0, 0, 0, 0, 0, 1 };
		int[] result = new int[9];
		for (int i = 0; i < 8; i++) {
			if (sum[i] < minus[i]) {
				sum[i + 1]--;
				sum[i] += 16;
			}
			result[i] = sum[i] - minus[i];
		}
		sb = new StringBuilder();
		for (int i = 7; i >= 0; i--) {
			if(result[i]!=0){
				for(int j=i;j>=0;j--){
					sb.append(letter[result[j]]);
				}
				break;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		System.out.println(obj.toHex(-2147483648));
		System.out.println(obj.toHex(-1));
	}

}
