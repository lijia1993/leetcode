public class Solution {
	public int findPos(int[] nums, int head, int tail, int val) {
		if (val >= nums[tail]) {
			return tail;
		}
		if (val < nums[head]) {
			return head - 1;
		}
		int l = head;
		int r = tail;
		while (l < r) {
			int mid_pos = (l + r) / 2;
			int mid_val = nums[mid_pos];
			if (val < mid_val) {
				r = mid_pos - 1;
				if (l == r)
					return l;
				continue;
			}
			if (val >= mid_val) {
				if (val < nums[mid_pos + 1]) {
					return mid_pos;
				}
				l = mid_pos + 1;
				continue;
			}
		}
		return l;
	}

	public int findSituation1(int findPos,int[] a,int[] b,int al,int ar,int bl,int br,int lrank,int rrank) {
		int leftpos = findPos(a,al,ar,b[bl]);
		int rightpos = findPos(a,al,ar,b[br]);
		int newlrank = leftpos-al+1+lrank;
		if(newlrank==findPos){
			return b[bl];
		}
		if(findPos<newlrank){
			return findSituation3(findPos,a,al,leftpos,lrank,-1);
		}
		int newrrank = rrank-(ar-rightpos);
		if(newrrank==findPos){
			return b[br];
		}
		if(findPos>newrrank){
			return findSituation3(findPos,a,rightpos,ar,-1,rrank);
		}
		return findSituation1(findPos,b,a,bl,br,leftpos+1,rightpos,newlrank,newrrank);
	}

	public int findSituation2(int findPos,int[] a,int[] b,int al,int ar,int bl,int br,int lrank,int rrank) {
		int leftpos = findPos(a,al,ar,b[bl]);
		int rightpos = findPos(b,bl,br,a[ar]);
		int newlrank = leftpos-al+1+lrank;
		if(newlrank==findPos){
			return b[bl];
		}
		if(findPos<newlrank){
			return findSituation3(findPos,a,al,leftpos,lrank,-1);
		}
		int newrrank = rrank-(br-rightpos);
		if(newrrank==findPos){
			return a[ar];
		}
		if(findPos>newrrank){
			return findSituation3(findPos,b,rightpos,br,-1,rrank);
		}
		return findSituation2(findPos,b,a,bl,rightpos,leftpos+1,ar,newlrank,newrrank);
	}

	public int findSituation3(int findPos,int[] a,int l,int r,int lrank,int rrank) {
		if(lrank>-1){
			return a[l+findPos-lrank];
		}
		return a[r-rrank+findPos];
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if(nums1.length==0){
			int mid_pos1 = (nums2.length - 1) / 2;
			int mid_pos2 = nums2.length / 2;
			int mid1_val = 0;
			int mid2_val = 0;
			mid1_val = findSituation3(mid_pos1,nums2,0,nums2.length-1,0,nums2.length-1);
			mid2_val = findSituation3(mid_pos2,nums2,0,nums2.length-1,0,nums2.length-1);
			return (mid1_val + mid2_val) * 1.0 / 2;
		}
		if(nums2.length==0){
			int mid_pos1 = (nums1.length - 1) / 2;
			int mid_pos2 = nums1.length / 2;
			int mid1_val = 0;
			int mid2_val = 0;
			mid1_val = findSituation3(mid_pos1,nums1,0,nums1.length-1,0,nums1.length-1);
			mid2_val = findSituation3(mid_pos2,nums1,0,nums1.length-1,0,nums1.length-1);
			return (mid1_val + mid2_val) * 1.0 / 2;
		}
		if (nums1[0] > nums2[0]) {
			int[] tmp = nums1;
			nums1 = nums2;
			nums2 = tmp;
		}
		int len1 = nums1.length;
		int len2 = nums2.length;
		int mid_pos1 = (len1 + len2 - 1) / 2;
		int mid_pos2 = (len1 + len2) / 2;
		int mid1_val = 0;
		int mid2_val = 0;
		if(nums1[len1-1]>=nums2[len2-1]){
			mid1_val = findSituation1(mid_pos1,nums1,nums2,0,len1-1,0,len2-1,0,len1+len2-1);
			mid2_val = findSituation1(mid_pos2,nums1,nums2,0,len1-1,0,len2-1,0,len1+len2-1);
		}
		else{
			if(nums2[0]>=nums1[len1-1]){
				if(len1==len2){
					mid1_val = nums1[len1-1];
					mid2_val = nums2[0];
				}
				else{
					if(len1>len2){
						mid1_val = findSituation3(mid_pos1,nums1,0,len1-1,0,len1-1);
						mid2_val = findSituation3(mid_pos2,nums1,0,len1-1,0,len1-1);
					}
					else{
						mid1_val = findSituation3(mid_pos1,nums2,0,len2-1,len1,len1+len2-1);
						mid2_val = findSituation3(mid_pos2,nums2,0,len2-1,len1,len1+len2-1);
					}
				}
			}
			else{
				mid1_val = findSituation2(mid_pos1,nums1,nums2,0,len1-1,0,len2-1,0,len1+len2-1);
				mid2_val = findSituation2(mid_pos2,nums1,nums2,0,len1-1,0,len2-1,0,len1+len2-1);
			}
		}
		return (mid1_val + mid2_val) * 1.0 / 2;
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
//		int[] nums = new int[] { 5, 5, 5, 5, 5 };
//		int val = 5;
//		int head = 0;
//		int tail = nums.length - 1;
//		System.out.println(obj.findPos(nums, head, tail, val));
		
		int[] nums1 = new int[]{3,10};
		int[] nums2 = new int[]{1,2,4,5,6,7,8,9};
		System.out.println(obj.findMedianSortedArrays(nums1, nums2));
	}
}