public class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int pos = len-1;
        while(pos>0&&nums[pos]<=nums[pos-1]){
        	pos--;
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
    }
    
    public static void main(String[] args) {
		Solution obj = new Solution();
		int[] nums = new int[]{1,1,5};
		obj.nextPermutation(nums);
	}
}