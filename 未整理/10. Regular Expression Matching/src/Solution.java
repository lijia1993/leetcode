public class Solution {
	public boolean isMatchByPos(String s,int spos,int slen,String p,int ppos,int plen){
		if(ppos==plen){
			return spos==slen;
		}
		if(ppos+1<plen&&p.charAt(ppos+1)=='*'){
			while((spos<slen)&&(p.charAt(ppos)==s.charAt(spos)||p.charAt(ppos)=='.')){
				if(isMatchByPos(s,spos,slen,p,ppos+2,plen)){
					return true;
				}
				spos++;
			}
			return isMatchByPos(s,spos,slen,p,ppos+2,plen);
		}
		else{
			if((spos<slen)&&(p.charAt(ppos)==s.charAt(spos)||p.charAt(ppos)=='.')){
				return isMatchByPos(s,spos+1,slen,p,ppos+1,plen);
			}
		}
		return false;
	}
	
	public boolean isMatch(String s, String p) {
    	int len_s = s.length();
    	int len_p = p.length();
    	if(len_s==0&&len_p==0){
    		return true;
    	}
    	if(len_p==0||p.charAt(0)=='*'){
    		return false;
    	}
        return isMatchByPos(s,0,len_s,p,0,len_p);
    }
    
    
    public static void main(String[] args) {
		String s = "aa";
		String p = "a*";
		System.out.println(new Solution().isMatch(s, p));
	}
//    "abc"
//    ".*d"
//    "aa"
//    "a"  
//    "aa"
//    "aa"  
//    "aaa"
//    "aa"  
//    "aa"
//    "a*"  
//    "aa"
//    ".*"  
//    "ab"
//    ".*"  
//    "aab"
//    "c*a*b"
//    "aaa"
//    "a*a"
//    "ab"
//    ".*c"
//    "a"
//    "ab*"
//    "bbbba"
//    ".*a*a"
//    "aaaaaaaaaaaaab"
//    "a*a*a*a*a*a*a*a*a*a*c"
}