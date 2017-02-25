public class Solution {
    public int divide(int dividend, int divisor) {
    	if(dividend==Integer.MIN_VALUE&&divisor==-1){
    		return Integer.MAX_VALUE;
    	}
    	if(divisor==Integer.MIN_VALUE){
    		if(dividend==Integer.MIN_VALUE){
    			return 1;
    		}
    		else{
    			return 0;
    		}
    	}
    	int sign = 1;
    	if((dividend>0&&divisor<0)||(dividend<0&&divisor>0)){
    		sign = -1;
    	}
    	double db_dividend = Math.abs(dividend+0.0);
    	int tmp_divisor = Math.abs(divisor);
    	divisor = Math.abs(divisor);
    	int ans = 0;
    	int power = 0;
    	while(true){
    		if(((double)tmp_divisor+(double)tmp_divisor)>Integer.MAX_VALUE){
    			break;
    		}
    		tmp_divisor = tmp_divisor<<1;
    		power++;
    	}
    	while(db_dividend>=divisor){
    		if(db_dividend>=tmp_divisor){
    			db_dividend-=tmp_divisor;
    			ans+=(1<<power);
    			continue;
    		}
    		tmp_divisor = tmp_divisor>>1;
    		power--;
    	}
        return ans*sign;
    }
    
    public static void main(String[] args) {
    	int a = -2147483648, b = 1;
		System.out.println(new Solution().divide(a, b));
		System.out.println(a/b);
		
	}
}