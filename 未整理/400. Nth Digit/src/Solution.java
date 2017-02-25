public class Solution {
    public int findNthDigit(int n) {
    	int ans = 0;
    	int pow = 0;
    	int x = n;
    	while(true){
    		double tmp = (Math.pow(10, pow+1)-Math.pow(10,pow))*(pow+1);
    		if(x>tmp){
    			pow++;
    			x=(int)(x-tmp);
    			continue;
    		}
    		int num = (int)(Math.pow(10, pow))+(x-1)/(pow+1);
    		int th = x%(pow+1);
    		if(th==0) th = pow+1;
    		ans = num/((int)Math.pow(10,pow+1-th))%10;
    		break;
    	}
        return ans;
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().findNthDigit(1000000000));
	}
}