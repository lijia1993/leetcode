import java.util.HashMap;
import java.util.Map;

public class Solution {
	public boolean wordPattern(String pattern, String str) {
		int len_pattern = pattern.length();
		String[] words = str.split(" ");
		if(words.length!=len_pattern) return false;
		Map<Character,String> hashMap = new HashMap<Character,String>(len_pattern);
		Map<String,Character> reflectHashMap = new HashMap<String,Character>(len_pattern);
		for(int i=0;i<len_pattern;i++){
			char pattern_ch = pattern.charAt(i);
			String word = words[i];
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
	public static void main(String[] args) {
		String s = "1 2 3 5";
		String[] r = s.split(" ");
		for(String a:r){
			System.out.println(a.length());
		}
		Map<String,String> hashMap = new HashMap<String,String>();
		hashMap.put("a", "bb");
		System.out.println(hashMap.get("a"));
		System.out.println(hashMap.get("b"));
	}
}
