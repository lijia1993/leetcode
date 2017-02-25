public class Solution {
    public String addBinary(String a, String b) {
    	int len_a = a.length();
    	int len_b = b.length();
    	char[] a_rev = new StringBuilder(a).reverse().toString().toCharArray();
    	char[] b_rev = new StringBuilder(b).reverse().toString().toCharArray();
    	int[] sum = new int[len_a+len_b+1];
    	
    	for(int i=0;i<len_a;i++){
    		sum[i] = a_rev[i]-'0';
    	}
    	int carry = 0;
    	for(int i=0;i<len_a+len_b+1;i++){
    		if(i<len_b){
    			sum[i] = sum[i] + (b_rev[i]-'0') + carry;
    		}
    		else{
    			sum[i] = sum[i] + carry;
    		}
    		carry = sum[i] / 2;
    		sum[i] = sum[i] % 2;
    	}
    	int end=len_a+len_b;
    	while(end>0&&sum[end]==0) end--;
    	StringBuilder result = new StringBuilder();
    	for(int i=end;i>=0;i--){
    		result.append(String.valueOf(sum[i]));
    	}
        return result.toString();
    }
    public static void main(String[] args) {
		System.out.println(new Solution().addBinary("0", "0"));
	}
}