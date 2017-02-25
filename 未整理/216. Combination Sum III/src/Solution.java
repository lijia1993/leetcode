import java.util.ArrayList;
import java.util.List;

public class Solution {
	public void addToResult(int[] candidates, int[] numsOf, List<List<Integer>> result) {
		int n = candidates.length;
		List<Integer> thisAns = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= numsOf[i]; j++) {
				thisAns.add(candidates[i]);
			}
		}
		result.add(thisAns);
		return;
	}

	public void solve(int[] candidates, int[] numsOf, int curPos, int rest, List<List<Integer>> result,int curk,int k) {
		if(curk>=k) return;
		int n = candidates.length;
		if (curPos == n - 1) {
			if (rest == candidates[curPos] && curk+1==k) {
				numsOf[curPos] = 1;
				addToResult(candidates, numsOf, result);
				numsOf[curPos] = 0;
			}
			return;
		}
		for (int i = 1; i >= 0; i--) {
			int tmp_rest = rest - candidates[curPos] * i;
			if (tmp_rest == 0 && curk+1==k) {
				numsOf[curPos] = i;
				addToResult(candidates, numsOf, result);
				numsOf[curPos] = 0;
				return;
			}
			if(tmp_rest<=0){
				return;
			}
			numsOf[curPos] = i;
			if(i==0){
				solve(candidates, numsOf, curPos + 1, tmp_rest, result,curk,k);
			}
			else{
				solve(candidates, numsOf, curPos + 1, tmp_rest, result,curk+1,k);
			}
			numsOf[curPos] = 0;
		}
		return;
	}

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int[] candidates = new int[]{1,2,3,4,5,6,7,8,9};
    	int[] numsOf = new int[candidates.length];
    	solve(candidates,numsOf,0,n,result,0,k);
    	return result;
	}
	
	public static void main(String[] args) {
		Solution obj = new Solution();
		obj.combinationSum3(3, 9);
	}
}
