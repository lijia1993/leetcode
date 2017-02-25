public class Solution {
    public boolean isPerfectSquare(int num) {
    	if(num==0) return true;
        double left = 1,right = num;
        while(left<=right){
        	double mid = ((int)(left+right))/2;
        	if((int)mid*(int)mid==num) return true;
        	if(mid*mid>num){
        		right = mid-1;
        	}
        	else{
        		left = mid+1;
        	}
        }
    	return false;
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().isPerfectSquare(100));
	}
}