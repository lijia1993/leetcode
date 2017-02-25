public class Solution {
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for(int i=1;i<=n;i++){
        	nums[i-1] = i;
        }
        for(int times=2;times<=k;times++){
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
        StringBuilder sb = new StringBuilder(n);
        for(int i=0;i<n;i++){
        	sb.append(nums[i]);
        }
        return sb.toString();
    }
}