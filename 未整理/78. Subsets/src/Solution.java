import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int len = nums.length;
        int[] table = new int[len+1];
        table[0]=-1;
        while(true){
        	table[0]++;
        	int cur = 0;
        	while(table[cur]==2){
        		table[cur] = 0;
        		cur++;
        		table[cur]++;
        	}
        	if(cur==len) break;
        	List<Integer> tmpAns = new ArrayList<Integer>();
        	for(int i=0;i<len;i++){
        		if(table[i]==1){
        			tmpAns.add(nums[i]);
        		}
        	}
        	result.add(tmpAns);
        }
        return result;
    }
}