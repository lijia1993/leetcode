public class Solution {
	public double myPow(double x, int n) {
		if(n==0) return 1;
    	boolean flags = true;
    	double nn = n;
    	if(n<0){
    		flags = false;
    		nn=0-nn;
    	}
    	double ans = 1;
    	int base2 = (int)(Math.log(nn)/Math.log(2));
    	double[] storeX = new double[base2+1];
    	storeX[0] = x;
    	for(int i=1;i<=base2;i++){
    		storeX[i] = storeX[i-1] * storeX[i-1];
    	}
    	for(int i=base2;i>=0;i--){
    		double nnn = Math.pow(2, i);
    		for(int j=1;j<=(int)(nn/nnn);j++){
    			if(flags){
        			ans *=storeX[i];
        		}else{
        			ans /=storeX[i];
        		}
    		}
    		nn-=((int)(nn/nnn))*nnn;
    	}
        return ans;
    }
    
    public static void main(String[] args) {
    	System.out.println(new Solution().myPow(-1
    			, -2147483648));
		System.out.println(Math.pow(-1,-2147483648));
	}
}