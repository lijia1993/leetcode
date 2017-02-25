import java.util.ArrayList;
import java.util.List;

public class Solution {
	public boolean isValid(String s){
		if(s.length()>1&&s.charAt(0)=='0')return false;
		int x = Integer.parseInt(s);
		if(x>=0&&x<=255) return true;
		return false;
	}
	
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        int len = s.length();
        for(int i=0;i<len-3;i++){
        	if(i>2){
        		break;
        	}
        	for(int j=i+1;j<len-2;j++){
        		if(j-i>3){
        			break;
        		}
        		if(len-j>9){
        			break;
        		}
        		for(int k=j+1;k<len-1;k++){
        			if(len-k>6){
        				break;
        			}
        			String s1 = s.substring(0, i+1);
        			String s2 = s.substring(i+1,j+1);
        			String s3 = s.substring(j+1,k+1);
        			String s4 = s.substring(k+1,len);
        			if(isValid(s1)&&isValid(s2)&&isValid(s3)&&isValid(s4)){
        				String tmps = s1 + "." + s2 + "." + s3 + "." + s4;
        				result.add(tmps);
        			}
        		}
        	}
        }
        return result;
    }
    
    public static void main(String[] args) {
//		new Solution().restoreIpAddresses("25525511135");
		new Solution().restoreIpAddresses("10381");
	}
}