import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
    	List<String> result = new ArrayList<String>();
    	Map<String,Boolean> map = new HashMap<>();
    	int len = s.length();
    	for(int i=0;i<len;i++){
    		if(i+10>len){
    			break;
    		}
    		String originSub = s.substring(i,i+10);
    		if(!map.containsKey(originSub)){
    			map.put(originSub, true);
    		}
    		else{
    			if(!result.contains(originSub)){
    				result.add(originSub);
    			}
    		}
    	}
    	return result;
    }
    
    public static void main(String[] args) {
    	String s = "AAAAAAAAAAAA";
    	new Solution().findRepeatedDnaSequences(s);
	}
}