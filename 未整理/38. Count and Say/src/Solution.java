public class Solution {
    public String countAndSay(int n) {
    	if(n==0) return "";
    	String result = "1";
    	for(int i=2;i<=n;i++){
    		int len = result.length();
    		StringBuilder sb = new StringBuilder();
    		int j=0;
    		while(j<len){
    			int count=1;
    			while(j+1<len&&result.charAt(j+1)==result.charAt(j)){
    				j++;
    				count++;
    			}
    			sb.append(String.valueOf(count));
    			sb.append((result).charAt(j));
    			j++;
    		}
    		result=sb.toString();
    	}
        return result;
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().countAndSay(3));
	}
}