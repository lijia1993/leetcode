public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
    	if(n>10) n=10;
    	int[] f = new int[11];
    	f[0] = 1; f[1] = 10;
    	for(int i=2;i<=10;i++){
    		f[i] = f[i-1] + (f[i-1]-f[i-2])*(11-i);
    	}
        return f[n];
    }
    public static void main(String[] args) {
		System.out.println(new Solution().countNumbersWithUniqueDigits(10));
	}
}