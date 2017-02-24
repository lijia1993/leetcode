import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution {
	public void quicksort2elements(int[][] num,int l,int r){
		int mid = (l+r)/2;
		int mid0 = num[mid][0];
		int midVal = num[mid][1];
		int left = l,right = r;
		while(l<r){
			while(l<r&&(num[l][1]>midVal||(num[l][1]==midVal&&num[l][0]>mid0))) l++;
			while(l<r&&(num[r][1]<midVal||(num[r][1]==midVal&&num[r][0]<mid0))) r--;
			int tmp = num[l][0];
			num[l][0] = num[r][0];
			num[r][0] = tmp;
			tmp = num[l][1];
			num[l][1] = num[r][1];
			num[r][1] = tmp;
			l++;
			r--;
		}
		if(left<r) quicksort2elements(num, left, r+1);
		if(right>l) quicksort2elements(num, l-1, right);
	}
	
    public List<Integer> topKFrequent(int[] nums, int k) {
    	List<Integer> ans = new ArrayList<Integer>();
    	Arrays.sort(nums);
    	int tmp = nums[0];
    	int count = 1;
    	int pos = 0;
    	int n = nums.length;
    	int[][] array = new int[n][2];
    	for(int i=1;i<n;i++){
    		if(nums[i]!=tmp){
    			array[pos][0] = tmp;
    			array[pos][1] = count;
    			pos++;
    			count = 1;
    		}
    		else{
    			count++;
    		}
    		tmp = nums[i];
    	}
    	array[pos][0] = tmp;
		array[pos][1] = count;
    	quicksort2elements(array,0,pos);
    	for(int i=1;i<=k;i++){
    		ans.add(array[i-1][0]);
    	}
        return ans;
    }
    
    public static void main(String[] args) {
		int[] nums = new int[]{5,1,-1,-8,-7,8,-5,0,1,10,8,0,-4,3,-1,-1,4,-5,4,-3,0,2,2,2,4,-2,-4,8,-7,-7,2,-8,0,-8,10,8,-8,-2,-9,4,-7,6,6,-1,4,2,8,-3,5,-9,-3,6,-8,-5,5,10,2,-5,-1,-5,1,-3,7,0,8,-2,-3,-1,-5,4,7,-9,0,2,10,4,4,-4,-1,-1,6,-8,-9,-1,9,-9,3,5,1,6,-1,-2,4,2,4,-6,4,4,5,-5};
		new Solution().topKFrequent(nums, 7);
	}
}