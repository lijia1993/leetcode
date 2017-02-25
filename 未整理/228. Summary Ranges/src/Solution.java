import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
    	List<String> ans = new ArrayList<String>();
        if(nums.length==0) return ans;
    	int st = nums[0],ed = nums[0];
    	for(int i=1;i<nums.length;i++){
    		if(nums[i]!=nums[i-1]+1){
    			if(st==ed){
    				ans.add(String.valueOf(st));
    			}
    			else{
    				ans.add(st+"->"+ed);
    			}
    			st = nums[i];
    		}
    		ed = nums[i];
    	}
    	if(st==ed){
			ans.add(String.valueOf(st));
		}
		else{
			ans.add(st+"->"+ed);
		}
        return ans;
    }
    
    public static void main(String[] args) {
		int[] nums = new int[]{0,1,2,4,5,7};
		new Solution().summaryRanges(nums);
	}
}