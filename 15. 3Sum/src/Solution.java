import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int len = nums.length;
        for(int i=0;i<len-2;i++){
        	if (i > 0 && nums[i] == nums[i-1]) continue;  
        	int start = i+1;
        	int end = len-1;
        	while(start<end){
        		int tmpSum = nums[i] + nums[start] +nums[end];
        		if(tmpSum==0){
        			List<Integer> tmpAns = new ArrayList<Integer>();
        			tmpAns.add(nums[i]);
        			tmpAns.add(nums[start]);
        			tmpAns.add(nums[end]);
        			result.add(tmpAns);
        			while (start < end && nums[start] == nums[start+1]) start++;  
                    while (start < end && nums[end] == nums[end-1]) end--;
        			start++;
        			end--;
        			continue;
        		}
        		if(tmpSum<0){
        			start++;
        		}
        		else{
        			end--;
        		}
        		
        	}
        }
        return result;
    }
    public static void main(String[] args) {
		Solution obj = new Solution();
		int[] nums = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
		obj.threeSum(nums);
	}
}