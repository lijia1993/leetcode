import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    	Map<Integer,Integer> map = new HashMap<Integer,Integer>(k);
    	int len = nums.length;
    	for(int i=0;i<len;i++){
    		if(map.get(nums[i])==null){
    			map.put(nums[i], i);
    		}
    		else{
    			int pos = map.get(nums[i]);
    			if(Math.abs(pos-i)<=k){
    				return true;
    			}
    			map.put(nums[i], i);
    		}
    	}
        return false;
    }
}