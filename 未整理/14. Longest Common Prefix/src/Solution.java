public class Solution {
    public String longestCommonPrefix(String[] strs) {
    	StringBuilder result = new StringBuilder();
    	if(strs.length==0) return result.toString();
    	int len_min=strs[0].length();
    	for(String str:strs){
    		if(str.length()<len_min) len_min = str.length();
    	}
    	for(int i=0;i<len_min;i++){
    		char c = strs[0].charAt(i);
    		for(String str:strs){
    			if(c!=str.charAt(i))return result.toString();
    		}
    		result.append(c);
    	}
        return result.toString();
    }
}