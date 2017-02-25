import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int romanToInt(String s) {
		int ans = 0, len = s.length();
		Map<Character, Integer> numMap = new HashMap<Character, Integer>();
		numMap.put('M', 1000);
		numMap.put('D', 500);
		numMap.put('C', 100);
		numMap.put('L', 50);
		numMap.put('X', 10);
		numMap.put('V', 5);
		numMap.put('I', 1);
		for(int i=0;i<len;i++){
			int cur = numMap.get(s.charAt(i));
			if(i+1<len&&cur<numMap.get(s.charAt(i+1))){
				cur = 0-cur;
			}
			ans+=cur;
		}
		return ans;
	}
}