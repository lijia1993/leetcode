import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isHappy(int n) {
    	if(n<1) return false;
    	Set<Integer> existNum = new HashSet<Integer>();
    	existNum.add(n);
    	int tmp = n;
    	while(tmp!=1){
    		int sum = 0;
    		while(tmp!=0){
    			sum += (tmp%10)*(tmp%10);
    			tmp/=10;
    		}
    		if(existNum.contains(sum)) return false;
    		tmp = sum;
    		existNum.add(tmp);
    	}
        return true;
    }
}