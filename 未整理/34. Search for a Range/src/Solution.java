public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1,-1};
    	int left = 0, right = nums.length-1;
    	if(nums[left]==target){
    		ans[0] = left;
    	}
    	else{
    		while(left<=right){
    			int mid = (left+right) / 2;
    			if(nums[mid]==target){
    				if(mid>0&&nums[mid-1]!=target){
    					ans[0] = mid;
    					break;
    				}
    				else{
    					right = mid-1;
    				}
    				continue;
    			}
    			if(nums[mid]<target){
    				left = mid + 1;
    			}
    			else{
    				right = mid - 1;
    			}
    		}
    	}
    	
    	left = 0; right = nums.length-1;
    	if(nums[right]==target){
    		ans[1] = right;
    	}
    	else{
    		while(left<=right){
    			int mid = (left+right) / 2;
    			if(nums[mid]==target){
    				if(mid<nums.length-1&&nums[mid+1]!=target){
    					ans[1] = mid;
    					break;
    				}
    				else{
    					left = mid+1;
    				}
    				continue;
    			}
    			if(nums[mid]<target){
    				left = mid + 1;
    			}
    			else{
    				right = mid - 1;
    			}
    		}
    	}
    	return ans;
    }
    
    public static void main(String[] args) {
		int[] nums = new int[]{5, 7, 7, 8, 8, 10};
		new Solution().searchRange(nums, 8);
	}
}