public class Solution {
    public boolean isPalindrome(int x) {
    	if(x<0) return false;
    	if(x==0) return true;
    	int len = 0,tmp = x;
    	while(tmp!=0){
    		tmp/=10;
    		len++;
    	}
    	for(int i=len;i>=(len+1)/2+1;i--){
    		int base1 = (int)Math.pow(10, i-1);
    		int base2 = (int)Math.pow(10, len-i);
    		if((x/base1%10)!=(x/base2%10)) return false;
    	}
        return true;
    }
    public static void main(String[] args) {
		System.out.println(new Solution().isPalindrome(121));
	}
}