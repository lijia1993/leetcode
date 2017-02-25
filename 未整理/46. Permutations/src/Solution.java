import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public void addToList(List<List<Integer>> result,int[] nums){
		List<Integer> tmpList =  new ArrayList<>();
		for(int num:nums){
			tmpList.add(num);
		}
		result.add(tmpList);
	}
	
    public List<List<Integer>> permute(int[] nums) {
    	Arrays.sort(nums);
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	addToList(result,nums);
    	while(true){
    		int len = nums.length;
            int pos = len-1;
            while(pos>0&&nums[pos]<=nums[pos-1]){
            	pos--;
            }
            if(pos==0){
            	break;
            }
            if(pos>0){
            	int baseNum = nums[pos-1];
            	for(int i=len-1;i>=pos;i--){
            		if(nums[i]>baseNum){
            			int tmp = nums[i];
            			nums[i] = baseNum;
            			nums[pos-1] = tmp;
            			break;
            		}
            	}
            }
            int left = pos,right = len-1;
            while(left<right){
            	int tmp = nums[left];
            	nums[left] = nums[right];
            	nums[right] = tmp;
            	left++;
            	right--;
            }
            addToList(result,nums);
    	}
    	return result;
    }
}