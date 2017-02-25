
public class Solution {
	public String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();
		int tmp = n;
		while(tmp>0){
			sb.append((char)((tmp-1)%26+'A'));
			tmp=(tmp-1)/26;
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		System.out.println(obj.convertToTitle(28));
	}

}
