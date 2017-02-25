public class Solution {
    public void sortColors(int[] nums) {
        int[] num = new int[3];
        int len = nums.length;
        for(int i=0;i<len;i++){
        	num[nums[i]]++;
        }
        int pos = -1;
        for(int i=0;i<3;i++){
        	for(int j=1;j<=num[i];j++){
        		pos++;
        		nums[pos]=i;
        	}
        }
    }
}