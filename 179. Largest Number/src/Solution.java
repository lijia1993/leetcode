
public class Solution {
	public int myCompare(int x,int y){
		if(x==y) return 0;
		String s1 = String.valueOf(x)+String.valueOf(y);
		String s2 = String.valueOf(y)+String.valueOf(x);
		int len = s1.length();
		for(int i=0;i<len;i++){
			if(s1.charAt(i)>s2.charAt(i)){
				return 1;
			}
			if(s1.charAt(i)<s2.charAt(i)){
				return -1;
			}
		}
		return 0;
	}
	
	public void quicksort(int[] nums,int first,int last){		
        int i,j,t,temp;
        if(first>last)
            return;
        temp=nums[first]; //temp中存的就是基准数
        i=first;
        j=last;
        while(i!=j)
        {

            //顺序很重要，要先从右边开始找
            while(myCompare(nums[j],temp)<=0 && i<j)
                j--;
            //再找左边的
            while(myCompare(nums[i],temp)>=0 && i<j)
                i++;
            //交换两个数在数组中的位置
            if(i<j)
            {
                t=nums[i];
                nums[i]=nums[j];
                nums[j]=t;
            }
        }
        //最终将基准数归位
        nums[first]=nums[i];
        nums[i]=temp;
        
        quicksort(nums,first,i-1);//继续处理左边的，这里是一个递归的过程
        quicksort(nums,i+1,last);//继续处理右边的 ，这里是一个递归的过程
	}
	
    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        quicksort(nums,0,nums.length-1);
        boolean flags = false;
        for(int i=0;i<nums.length;i++){
        	sb.append(String.valueOf(nums[i]));
        	if(nums[i]!=0){
        		flags = true;
        	}
        }
        if(!flags){
        	return "0";
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
		int[] nums = new int[]{1,2,3,1};
//		int[] nums = new int[]{9,6,3,0,7,4,1,8,5,2};
		System.out.println(new Solution().largestNumber(nums));
	}
}