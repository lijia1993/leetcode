import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<Integer> majorityElement(int[] nums) {
		int candidates1 = 0, num1 = 0;
		int candidates2 = 0, num2 = 0;
		for (int num : nums) {
			if (num1 == 0 && num2 == 0) {
				candidates1 = num;
				num1 = 1;
				continue;
			}
			if (num1 != 0 && num2 == 0) {
				if(candidates1==num){
					num1++;
					continue;
				}
				candidates2 = num;
				num2 =1;
				continue;
			}
			if (num1 == 0 && num2 != 0) {
				if(candidates2==num){
					num2++;
					continue;
				}
				candidates1 = num;
				num1 =1;
				continue;
			}
			if(candidates1==num){
				num1++;
				continue;
			}
			else if(candidates2==num){
				num2++;
				continue;
			}
			else{
				num1--;
				num2--;
			}
		}
		num1=0;num2=0;
		for(int num:nums){
			if(num==candidates1) num1++;
			if(num==candidates2) num2++;
		}
		List<Integer> result = new ArrayList<Integer>();
		if(num1>(nums.length)/3)result.add(candidates1);
		if(num2>(nums.length)/3&&candidates1!=candidates2)result.add(candidates2);
		return result;
	}

	public static void main(String[] args) {

	}

}
