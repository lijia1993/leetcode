
public class Solution {
	 public int getSum(int a, int b) {
		 int op_add = a^b;
		 int op_carry = (a&b)<<1;
		 while(op_carry!=0){
			 int new_add = op_add^op_carry;
			 int new_carry = (op_add&op_carry)<<1;
			 op_add = new_add;
			 op_carry = new_carry;
		 }
		 return op_add;
	 }
	
	public static void main(String[] args) {
		System.out.println(new Solution().getSum(-1, 1));
	}

}
