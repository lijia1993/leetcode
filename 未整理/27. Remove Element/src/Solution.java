import java.util.Arrays;

public class Solution {
    public int removeElement(int[] nums, int val) {
    	Arrays.sort(nums);
    	int len=nums.length,ans=len;
    	for(int i=0;i<len;i++){
    		if(nums[i]==val){
    			int j=i;
    			while(j+1<len&&nums[j+1]==val){
    				j++;
    			}
    			int count = j-i+1;
    			ans-=count;
    			for(int k=j+1;k<len;k++){
    				nums[k-count]=nums[k];
    			}
    			break;
    		}
    	}
        return ans;
    }
}