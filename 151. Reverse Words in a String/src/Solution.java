public class Solution {
	public void reverseWord(StringBuilder sb,int l,int r){
		while(l<r){
			char tmpc = sb.charAt(l);
			sb.setCharAt(l, sb.charAt(r));
			sb.setCharAt(r, tmpc);
			l++;
			r--;
		}
	}
	
    public String reverseWords(String s) {
    	s=s.trim();
    	int lenS = s.length();
    	StringBuilder sb = new StringBuilder();
    	for(int i=0;i<lenS;i++){
    		if(s.charAt(i)==' '){
    			sb.append(' ');
    			while(i<lenS&&s.charAt(i)==' '){
    				i++;
    			}
    			i--;
    			continue;
    		}
    		sb.append(s.charAt(i));
    	}
    	int len = sb.length();
    	reverseWord(sb,0,len-1);
    	int startPos = 0;
    	for(int i=0;i<len;i++){
    		if(sb.charAt(i)==' '){
    			reverseWord(sb,startPos,i-1);
    			startPos = i+1;
    		}
    	}
    	reverseWord(sb,startPos,len-1);
        return sb.toString();
    }
    
    public static void main(String[] args) {
		String s="   the   sky  is  blue  ";
    	System.out.println(new Solution().reverseWords(s));
	}
}