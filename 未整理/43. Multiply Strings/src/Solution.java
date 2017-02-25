public class Solution {
    public String multiply(String num1, String num2) {
    	int num1Len = num1.length();
    	int num2Len = num2.length();
    	if((num1Len==1&&num1.charAt(0)=='0')||(num2Len==1&&num2.charAt(0)=='0')){
    		return "0";
    	}
    	int[] tmpSum = new int[num1Len+num2Len-1];
    	for(int i=0;i<num1Len;i++){
    		for(int j=0;j<num2Len;j++){
    			tmpSum[i+j]+=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
    		}
    	}
    	StringBuilder sb = new StringBuilder();
    	int carry = 0;
    	for(int i=num1Len+num2Len-2;i>=0;i--){
    		tmpSum[i] = tmpSum[i] + carry;
    		carry = tmpSum[i]/10;
    		sb.append(String.valueOf(tmpSum[i]%10));
    	}
    	if(carry>0){
    		StringBuilder carrysb = new StringBuilder(String.valueOf(carry));
        	sb.append(carrysb.reverse());
    	}
        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
		Solution obj = new Solution();
		System.out.println(obj.multiply("1230", "0"));
	}
}