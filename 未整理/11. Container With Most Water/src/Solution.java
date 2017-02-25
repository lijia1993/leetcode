public class Solution {
    public int maxArea(int[] height) {
    	int ans = 0;
    	int len = height.length;
    	int left = 0;
    	int right = len-1;
    	while(left<right){
    		int tmpAns = Math.min(height[left],height[right]) * (right-left);
    		ans = Math.max(tmpAns, ans);
    		if(height[left]<height[right]){
    			left++;
    		}
    		else{
    			right--;
    		}
    	}
    	return ans;
    }
    
    public static void main(String[] args) {
		int[] height = new int[]{1,2,3,4,5,25,24,3,4};
		System.out.println(new Solution().maxArea(height));
	}
}