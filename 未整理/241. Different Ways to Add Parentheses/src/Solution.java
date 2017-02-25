import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<Integer> divideAndCal(List<Integer> nums,List<Character> ops,int l,int r){
		List<Integer> ans = new ArrayList<Integer>();
		if(l==r){
			ans.add(nums.get(l));
			return ans;
		}
		if(l+1==r){
			ans.add(cal(nums.get(l),nums.get(r),ops.get(l)));
			return ans;
		}
		for(int k=l;k<=r-1;k++){
			List<Integer> tmp_left = divideAndCal(nums,ops,l,k);
			List<Integer> tmp_right = divideAndCal(nums,ops,k+1,r);
			for(int num_left:tmp_left){
				for(int num_right:tmp_right){
					ans.add(cal(num_left,num_right,ops.get(k)));
				}
			}
		}
		return ans;
	}
	public int cal(int a,int b,char c){
		switch(c){
		case '+':return a+b;
		case '-':return a-b;
		case '*':return a*b;
		}
		return 0;
	}
	
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<Integer>();
        List<Integer> nums = new ArrayList<Integer>();
        List<Character> ops = new ArrayList<Character>();
        int num = 0;
        int len = input.length();
        for(int i=0;i<len;i++){
        	char c = input.charAt(i);
        	if(c>='0'&&c<='9'){
        		num = num*10 + c-'0';
        	}
        	else{
        		nums.add(num);
        		num = 0;
        		ops.add(c);
        	}
        }
        nums.add(num);
        int n = nums.size();
        result = divideAndCal(nums,ops,0,n-1);
        return result;
    }
    
    public static void main(String[] args) {
		String s = "2*3-4*5";
		System.out.println(new Solution().diffWaysToCompute(s));
	}
}