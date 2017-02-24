public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
    	if(m==n) return m;
    	int log1 = (int) (Math.log(m)/Math.log(2));
    	int log2 = (int) (Math.log(n)/Math.log(2));
    	if(log1!=log2){
    		return 0;
    	}
    	int ans = m;
    	int diff = n - m;
    	for(int i=1;i<=diff;i++){
    		ans &= (m+i);
    	}
        return ans;
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().rangeBitwiseAnd(2147483646,  2147483647));
	}
    
}