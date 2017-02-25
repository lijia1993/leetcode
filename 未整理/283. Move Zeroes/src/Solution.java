
public class Solution {

	public void moveZeroes(int[] nums) {
		int last = nums.length-1;
		int pos = last;
		while(pos>=0){
			if(nums[pos]==0){
				for(int i=pos+1;i<=last;i++)
					nums[i-1] = nums[i];
				nums[last]=0;
				last--;
			}
			pos--;
		}
	}

	public static void main(String[] args) {

	}

}
