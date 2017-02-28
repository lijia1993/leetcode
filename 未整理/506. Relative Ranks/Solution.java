import java.util.Arrays;

public class Solution506 {
    public String getRank(int rank) {
        switch (rank) {
            case 1:
                return "Gold Medal";
            case 2:
                return "Silver Medal";
            case 3:
                return "Bronze Medal";
            default:
                return String.valueOf(rank);
        }
    }

    public String[] findRelativeRanks(int[] nums) {
        String[] results = new String[nums.length];
        int[] cpOfNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(cpOfNums);
        for (int i = 0; i < nums.length; i++) {
            int left = 0, right = nums.length - 1;
            int target = nums[i];
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (cpOfNums[mid] == target) {
                    results[i] = getRank(nums.length - mid);
                    break;
                }
                if (cpOfNums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            System.out.println(results[i]);
        }
        return results;
    }

    public void test() {
        int[] nums = {5, 3, 2, 4, 1};
        System.out.println(findRelativeRanks(nums));
    }
}
