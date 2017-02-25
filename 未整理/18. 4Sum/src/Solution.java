import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	int len = nums.length;
    	if(len<=3){
    		return result;
    	}
        Arrays.sort(nums);
        for(int a1=0;a1<len-3;a1++){
        	if((a1>0)&&nums[a1]==nums[a1-1]){
				continue;
			}
        	for(int a2=a1+1;a2<len-2;a2++){
        		if((a2>a1+1)&&nums[a2]==nums[a2-1]){
    				continue;
    			}
        		for(int a3=a2+1;a3<len-1;a3++){
        			if((a3>a2+1)&&nums[a3]==nums[a3-1]){
        				continue;
        			}
        			int rest = target - nums[a1] - nums[a2] - nums[a3];
        			int left = a3+1;
        			int right = len-1;
        			if(rest<nums[left]||rest>nums[right]){
        				continue;
        			}
        			while(left<=right){
        				int mid = (left+right)/2;
        				if(rest==nums[mid]){
        					List<Integer> tmp = new ArrayList<Integer>();
        					tmp.add(nums[a1]);
        					tmp.add(nums[a2]);
        					tmp.add(nums[a3]);
        					tmp.add(rest);
        					result.add(tmp);
        					break;
        				}
        				if(rest<nums[mid]){
        					right = mid-1;
        				}
        				else{
        					left = mid+1;
        				}
        			}
        		}
        	}
        }
        return result;
    }
    
    public static void main(String[] args) {
		int[] nums = new int[]{1,0,-1,0,-2,2,0};
		int target = 0;
		Solution obj = new Solution();
		System.out.println(obj.fourSum(nums, target));
	}
}