import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<Integer> grayCode(int n) {
        List<Integer> result =  new ArrayList<Integer>();
        result.add(0);
        if(n==0) return result;
        result.add(1);
        for(int i=2;i<=n;i++){
        	int size = result.size();
        	for(int j=size-1;j>=0;j--){
        		result.add(((1<<(i-1))+result.get(j)));
        	}
        }
        return result;
    }
    
    public static void main(String[] args) {
		new Solution().grayCode(3);
	}
}