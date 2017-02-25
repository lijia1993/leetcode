import java.util.Arrays;

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
    	Arrays.sort(g);
    	Arrays.sort(s);
    	int i = 0;
    	int j = 0;
    	int len_g = g.length;
    	int len_s = s.length;
    	int ans = 0;
    	while(i<len_g&&j<len_s){
    		if(g[i]<=s[j]){
    			ans++;
    			i++;
    			j++;
    		}
    		else{
    			j++;
    		}
    	}
        return ans;
    }
}