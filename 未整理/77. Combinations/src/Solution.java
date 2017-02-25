import java.util.ArrayList;
import java.util.List;

public class Solution {
	public void solve(int curn,int n,int curk,int k,List<List<Integer>> result,List<Integer> curAns){
		if(curk==k){
			result.add(new ArrayList<>(curAns));
			return;
		}
		if(curn>=n) return;
		curAns.add(curn+1);
		solve(curn+1,n,curk+1,k,result,curAns);
		curAns.remove(curAns.size()-1);
		solve(curn+1,n,curk,k,result,curAns);
		return;
	}
	
    public List<List<Integer>> combine(int n, int k) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	solve(0,n,0,k,result,new ArrayList<Integer>());
    	return result;
    }
    
    public static void main(String[] args) {
		Solution obj = new Solution();
		obj.combine(4, 2);
	}
}