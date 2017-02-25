import java.util.ArrayList;
import java.util.Arrays;
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
	
	public void solve(int[] candidates,int[] numsOf,int curPos,int rest,List<List<Integer>> result,int[] counts){
		int n = candidates.length;
		if(curPos==n-1){
			if(rest%candidates[curPos]==0&&rest/candidates[curPos]<=counts[curPos]){
				numsOf[curPos] = rest/candidates[curPos];
				addToResult(candidates,numsOf,result);
				numsOf[curPos] = 0;
			}
			return;
		}
		for(int i=0;i<=counts[curPos];i++){
			int tmp_rest = rest - candidates[curPos]*i;
			if(tmp_rest<0) break;
			if(tmp_rest==0){
				numsOf[curPos] = i;
				addToResult(candidates,numsOf,result);
				numsOf[curPos] = 0;
				return;
			}
			numsOf[curPos] = i;
			solve(candidates,numsOf,curPos+1,tmp_rest,result,counts);
			numsOf[curPos] = 0;
		}
		return;
	}
	
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	Arrays.sort(candidates);
    	int len = candidates.length;
    	List<Integer> tmpArray = new ArrayList<Integer>();
    	List<Integer> tmpCount = new ArrayList<Integer>();
    	tmpArray.add(candidates[0]);
    	int ct = 1;
    	for(int i=1;i<len;i++){
    		if(candidates[i]==candidates[i-1]){
    			ct++;
    			continue;
    		}
    		tmpCount.add(ct);
    		tmpArray.add(candidates[i]);
    		ct = 1;
    	}
    	tmpCount.add(ct);
    	
    	int newSize = tmpArray.size();
    	int[] new_candidates = new int[newSize];
    	int[] counts = new int[newSize];
    	for(int i=0;i<newSize;i++){
    		new_candidates[i] = tmpArray.get(i);
    		counts[i] = tmpCount.get(i);
    	}
    	
    	int[] numsOf = new int[new_candidates.length];
    	solve(new_candidates,numsOf,0,target,result,counts);
    	return result;
    }
    
    public static void main(String[] args) {
		Solution obj = new Solution();
		int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
		int target = 8;
		obj.combinationSum2(candidates, target);
	}
}