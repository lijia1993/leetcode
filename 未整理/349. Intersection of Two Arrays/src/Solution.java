import java.util.HashSet;

public class Solution {

	public int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> resultSet = new HashSet<Integer>();
		HashSet<Integer> nums1Set = new HashSet<Integer>();
		for(int num:nums1){
			nums1Set.add(num);
		}
		for(int num:nums2){
			if(nums1Set.contains(num))resultSet.add(num);
		}
		int[] result = new int[resultSet.size()];
		int result_pos = -1;
		for(int num:resultSet ){
			result_pos++;
			result[result_pos]=num;
		}
		return result;
	}

	public static void main(String[] args) {

	}

}
