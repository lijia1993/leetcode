public class Solution {
    public int myAtoi(String str) {
    	str = str.trim();
    	int len = str.length();
    	if(len==0) return 0;
    	int sign = 1;
    	int ans = 0;
    	double isOverflow = 0;
    	for(int i=0;i<len;i++){
    		if(i==0 && str.charAt(0)=='-'){
    			sign = -1;
    			continue;
    		}
    		if(i==0 && str.charAt(0)=='+'){
    			sign = 1;
    			continue;
    		}
    		char c = str.charAt(i);
    		if(c>='0'&&c<='9'){
    			isOverflow = (double)ans*10 + (sign*(c-'0'));
    			if(sign==1 && isOverflow>0x7fffffff) return 0x7fffffff;
    			if(sign==-1 && isOverflow<0x80000000) return 0x80000000;
    			ans = ans*10 + (sign*(c-'0'));
    			continue;
    		}
    		return ans;
    	}
        return ans;
    }
}