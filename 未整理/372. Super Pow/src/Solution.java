public class Solution {
    public int superPow(int a, int[] b) {
    	int res = 1;
    	int bsize = b.length;
    	for(int i=0;i<bsize;i++){
    		res = (myPow(res,10)%1337)*(myPow(a,b[i])%1337)%1337;
    	}
        return res;
    }
    
    public int myPow(int x,int n){
    	if(n==0) return 1;
    	if(n==1) return x%1337;
    	return ((myPow(x,n/2)%1337) * (myPow(x,n-n/2)))%1337;
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().superPow(2, new int[]{1,2}));
	}
}