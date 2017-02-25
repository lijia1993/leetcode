import java.util.ArrayList;
import java.util.List;

public class Solution {
	public void addToResult(int[] candidates,int[] numsOf,List<List<Integer>> result){
		int n = candidates.length;
		List<Integer> thisAns = new ArrayList<Integer>();
		for(int i=0;i<n;i++){
			for(int j=1;j<=numsOf[i];j++){
				thisAns.add(candidates[i]);
			}
		}
		result.add(thisAns);
		return;
	}
	
	public void solve(int[] candidates,int[] numsOf,int curPos,int rest,List<List<Integer>> result){
		int n = candidates.length;
		if(curPos==n-1){
			if(rest%candidates[curPos]==0){
				numsOf[curPos] = rest/candidates[curPos];
				addToResult(candidates,numsOf,result);
				numsOf[curPos] = 0;
			}
			return;
		}
		int maxNum = rest/candidates[curPos];
		for(int i=0;i<=maxNum;i++){
			int tmp_rest = rest - candidates[curPos]*i;
			if(tmp_rest==0){
				numsOf[curPos] = i;
				addToResult(candidates,numsOf,result);
				numsOf[curPos] = 0;
				return;
			}
			numsOf[curPos] = i;
			solve(candidates,numsOf,curPos+1,tmp_rest,result);
			numsOf[curPos] = 0;
		}
		return;
	}
	
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	int[] numsOf = new int[candidates.length];
    	solve(candidates,numsOf,0,target,result);
    	return result;
    }
    
    public static void main(String[] args) {
		Solution obj = new Solution();
		int[] candidates = new int[]{7,3,6,5};
		int target = 7;
		obj.combinationSum(candidates, target);
	}
}