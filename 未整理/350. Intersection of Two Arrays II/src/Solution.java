import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		List<Integer> resultList = new ArrayList<Integer>();
		int p1 = 0, p2 = 0;
		while (p1 < nums1.length && p2 < nums2.length) {
			if (nums1[p1] == nums2[p2]) {
				resultList.add(nums1[p1]);
				if (p1 + 1 < nums1.length && p2 + 1 < nums2.length) {
					p1++;
					p2++;
					continue;
				} else {
					break;
				}
			}
			if (nums1[p1] < nums2[p2] && p1 + 1 < nums1.length) {
				p1++;
				continue;
			}
			if (nums1[p1] > nums2[p2] && p2 + 1 < nums2.length) {
				p2++;
				continue;
			}
			if (nums1[p1] < nums2[p2] && p1 + 1 == nums1.length) {
				break;
			}
			if (nums1[p1] > nums2[p2] && p2 + 1 == nums2.length) {
				break;
			}
		}
		int[] result = new int[resultList.size()];
		int result_pos = -1;
		for (int num : resultList) {
			result_pos++;
			result[result_pos] = num;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution obj = new Solution();
//		int[] nums1 = new int[]{9,1};
//		int[] nums2 = new int[]{7,8,3,9,0,0,9,1,5};
		int[] nums1 = new int[]{3,1,2};
		int[] nums2 = new int[]{1,1};
		System.out.println(obj.intersect(nums1, nums2));
	}
}
