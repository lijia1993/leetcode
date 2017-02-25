public class Solution {
    public int maxRotateFunction(int[] A) {
    	int n = A.length;
    	if(n==0) return 0;
    	int maxAns = 0x80000000;
    	for(int i=0;i<=n-1;i++){
    		int tmpAns = 0;
    		int point = n-1-i;
    		for(int j=0;j<n;j++){
    			point++;
    			if(point==n) point = 0;
    			tmpAns += A[point] * j;
    		}
    		maxAns = Math.max(maxAns, tmpAns);
    	}
        return maxAns;
    }
    
    public static void main(String[] args) {
    	int[] A = new int[]{4,3,2,6};
		System.out.println(new Solution().maxRotateFunction(A));
	}
}