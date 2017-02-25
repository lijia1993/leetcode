public class Solution {
    public int thirdMax(int[] nums) {
    	double firstmax = (double)(0x80000000)-1;
    	double secondmax = (double)(0x80000000)-1;
    	double thirdmax = (double)(0x80000000)-1;
    	for(int num:nums){
    		double n = num;
    		if(n>firstmax){
    			thirdmax = secondmax;
    			secondmax = firstmax;
    			firstmax = n;
    			continue;
    		}
    		if(n>secondmax&&num<firstmax){
    			thirdmax = secondmax;
    			secondmax = n;
    			continue;
    		}
    		if(n>thirdmax&&num<firstmax&&num<secondmax){
    			thirdmax = n;
    			continue;
    		}
    	}
    	int ans = (int)thirdmax;
    	if(thirdmax<0x80000000) ans = (int)firstmax;
        return ans;
    }
    
    public static void main(String[] args) {
		Solution obj = new Solution();
		int[] nums = new int[]{1,2,-2147483648};
		System.out.println(obj.thirdMax(nums));
	}
}