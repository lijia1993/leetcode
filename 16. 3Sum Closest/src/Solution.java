import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int ans = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for(int i=0;i<len;i++){
        	int left = i+1;
        	int right = len-1;
        	while(left<right){
        		int tmpSum = nums[left] + nums[right] + nums[i];
        		if(Math.abs(tmpSum-target)<Math.abs(ans-target)){
        			ans = tmpSum;
        		}
        		if(tmpSum<target){
        			left++;
        		}
        		else{
        			right--;
        		}
        	}
        }
        return ans;
    }
}