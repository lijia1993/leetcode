import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
    	int len_pattern = s.length();
		char[] words = t.toCharArray();
		if(words.length!=len_pattern) return false;
		Map<Character,Character> hashMap = new HashMap<Character,Character>(len_pattern);
		Map<Character,Character> reflectHashMap = new HashMap<Character,Character>(len_pattern);
		for(int i=0;i<len_pattern;i++){
			char pattern_ch = s.charAt(i);
			char word = words[i];
			if(hashMap.get(pattern_ch)==null){
				if(reflectHashMap.get(word)!=null){
					return false;
				}
				hashMap.put(pattern_ch, word);
				reflectHashMap.put(word, pattern_ch);
				continue;
			}
			if(!hashMap.get(pattern_ch).equals(word)) return false;
			if(reflectHashMap.get(word)!=pattern_ch) return false;
		}
		return true;
    }
}