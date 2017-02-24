import java.util.Random;

public class Solution {
	int[] nums;
	int[] originNums;
	
    public Solution(int[] nums) {
        this.nums = nums;
        this.originNums = nums.clone();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return originNums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
    	Random random = new Random();
    	int len = nums.length;
    	for(int i=0;i<len;i++){
    		int randomNum = random.nextInt(len);
    		int swapNum = len-i-1;
    		int tmp = nums[swapNum];
    		nums[swapNum] = nums[randomNum];
    		nums[randomNum] = tmp;
    	}
        return nums;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */