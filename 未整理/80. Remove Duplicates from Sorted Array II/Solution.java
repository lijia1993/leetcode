public class Solution80 {
    public int removeDuplicates(int[] nums) {
        final int occur = 2;
        if (nums.length<occur){
            return nums.length;
        }
        int index = occur;
        for(int i=index;i<nums.length;i++){
            if(nums[i]!=nums[index-occur]){
                nums[index++]=nums[i];
            }
        }
        return index;
    }

    public void test(){
        int[] nums = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
    }
}
