public class Solution {
    public int firstMissingPositive(int[] nums) {
    	int len = nums.length;
    	int tmp;
    	for(int i=0;i<len;i++){
    		while(true){
    			int num = nums[i];
        		if(i+1!=num){
        			if(num>len||num<=0||nums[num-1]==nums[i]){
        				break;
        			}
        			tmp = nums[i];
        			nums[i] = nums[num-1];
        			nums[num-1] = tmp;
        			continue;
        		}
    			break;
    		}
    	}
    	for(int i=0;i<len;i++){
    		if(nums[i]!=i+1){
    			return i+1;
    		}
    	}
        return len+1;
    }
    
    public static void main(String[] args) {
		Solution obj = new Solution();
		int[] nums = new int[]{1,2,0};
		System.out.println(obj.firstMissingPositive(nums));
	}
}