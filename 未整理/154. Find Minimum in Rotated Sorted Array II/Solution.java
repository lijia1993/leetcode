public class Solution154 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if(left==right) return nums[left];
            if (nums[left] < nums[right]) {
                return nums[left];
            }
            int mid = left + (right - left) / 2;
            if (nums[left] < nums[mid]) {
                left = mid + 1;
            } else if(nums[left] > nums[mid]){
                right = mid;
            }
            else{
                left++;
            }
        }
        return nums[0];
    }

    public void test() {
        int[] nums = {10,10,10,1,10};
        System.out.println(findMin(nums));
    }
}
