import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
    	List<Integer> dpList = new ArrayList<Integer>();
    	for(List<Integer> row:triangle){
    		int size = row.size();
    		if(size==1){
    			dpList.add(row.get(0));
    			continue;
    		}
    		dpList.add(dpList.get(size-2)+row.get(size-1));
    		for(int i=size-2;i>=0;i--){
    			if(i==0){
    				dpList.set(0, dpList.get(0)+row.get(0));
    				break;
    			}
    			int v1 = dpList.get(i-1);
    			int v2 = dpList.get(i);
    			dpList.set(i, Math.max(v1, v2)+row.get(i));
    		}
    	}
    	int ans = dpList.get(0);
    	for(int num:dpList){
    		ans = Math.max(ans, num);
    	}
        return ans;
    }
    
    public static void main(String[] args) {
    	List<List<Integer>> triangle = new ArrayList<List<Integer>>();
    	List<Integer> list1 = new ArrayList<Integer>();
    	list1.add(2);
    	
    	List<Integer> list2 = new ArrayList<Integer>();
    	list2.add(3);
    	list2.add(4);
    	
    	List<Integer> list3 = new ArrayList<Integer>();
    	list3.add(6);
    	list3.add(5);
    	list3.add(7);
    	
    	List<Integer> list4 = new ArrayList<Integer>();
    	list4.add(4);
    	list4.add(1);list4.add(8);list4.add(3);
    	triangle.add(list1);
	}
}