public class Solution {
	public String add2String(String s1,String s2){
		int len1 = s1.length();
		int len2 = s2.length();
		StringBuilder sb1 =  new StringBuilder(s1);
		sb1 = sb1.reverse();
		StringBuilder sb2 =  new StringBuilder(s2);
		sb2 = sb2.reverse();
		
		StringBuilder sb =  new StringBuilder();
		int carry = 0;
		int minLen = Math.min(len1, len2);
		for(int i=0;i<minLen;i++){
			int tmp = sb1.charAt(i) - '0' + sb2.charAt(i) - '0' + carry;
			sb.append(String.valueOf(tmp%10));
			carry = tmp / 10;
		}
		if(len1>minLen){
			for(int i=minLen;i<len1;i++){
				int tmp = sb1.charAt(i) - '0' + carry;
				sb.append(String.valueOf(tmp%10));
				carry = tmp / 10;
			}
		}
		else{
			for(int i=minLen;i<len2;i++){
				int tmp = sb2.charAt(i) - '0' + carry;
				sb.append(String.valueOf(tmp%10));
				carry = tmp / 10;
			}
		}
		if(carry>0)
			sb.append(String.valueOf(carry));
		return sb.reverse().toString();
	}
    public boolean isAdditiveNumber(String num) {
    	int len = num.length();
    	if(len<3) return false;
    	for(int i=0;i<len;i++){
    		for(int j=i+1;j<len;j++){
    			String s1 = num.substring(0,i+1);
    			String s2 = num.substring(i+1,j+1);
    			if(j+1>=len){
    				break;
    			}
    			String s3 = num.substring(j+1,len);
    			if(s2.length()>1&&s2.startsWith("0")||s3.length()>1&&s3.startsWith("0")){
    				continue;
    			}
    			boolean flags = true;
    			while(true){
    				if(Math.max(s1.length(),s2.length())>s3.length()){
    					flags =false;
    					break;
    				}
    				String tmp = add2String(s1,s2);
    				if(!s3.startsWith(tmp)){
    					flags = false;
    					break;
    				}
    				if(s3.equals(tmp)){
    					flags = true;
    					break;
    				}
    				s1 = s2;
    				s2 = tmp;
    				s3 = s3.substring(tmp.length(), s3.length());
    			}
    			if(flags){
    				return true;
    			}
    		}
    	}
        return false;
    }
    
    public static void main(String[] args) {
//    	String s1 = "1918384793";
//    	String s2 = "93242342";
    	Solution obj = new Solution();
//    	System.out.println(obj.add2String(s1, s2));
//    	System.out.println(Integer.parseInt(s1)+Integer.parseInt(s2));
    	String s = "101";
    	System.out.println(obj.isAdditiveNumber(s));
	}
}