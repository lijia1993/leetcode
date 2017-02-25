import java.util.ArrayList;
import java.util.List;

public class Solution {
	public String getLetters(int x){
		switch (x){
		case 2:return "abc";
		case 3:return "def";
		case 4:return "ghi";
		case 5:return "jkl";
		case 6:return "mno";
		case 7:return "pqrs";
		case 8:return "tuv";
		case 9:return "wxyz";
		}
		return "";
	}
	
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits.length()==0) return result;
        result.add("");
        int len = digits.length();
        for(int i=0;i<len;i++){
        	char c = digits.charAt(i);
        	if(c=='0'||c=='1') return null;
        	List<String> tmp = new ArrayList<String>();
        	for(String tmpString:result){
        		char[] digString = getLetters(c-'0').toCharArray();
        		for(char ch:digString){
        			tmp.add(tmpString+ch);
        		}
        	}
        	result = tmp;
        }
        return result;
    }
    
    public static void main(String[] args) {
		Solution obj = new Solution();
		obj.letterCombinations("23");
	}
}