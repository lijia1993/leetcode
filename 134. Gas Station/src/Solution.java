import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
	public void quicksort(List<int[]> list,int first,int last){
		int l = first, r = last, mid1 = list.get((first+last)/2)[0], mid2 = list.get((first+last)/2)[1];
		while(l<r){
			while(l<r&&((list.get(l)[0]>mid1)||(list.get(l)[0]==mid1&&list.get(l)[1]<mid2)))l++;
			while(l<r&&((list.get(r)[0]<mid1)||(list.get(r)[0]==mid1&&list.get(r)[1]>mid2)))r--;
			int tmp = list.get(l)[0];
			list.get(l)[0] = list.get(r)[0];
			list.get(r)[0] = tmp;
			tmp = list.get(l)[1];
			list.get(l)[1] = list.get(r)[1];
			list.get(r)[1] = tmp;
		}
		if(first<r) quicksort(list,first,r-1);
		if(l<last) quicksort(list,l+1,last);
	}
	
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	int n = gas.length;
    	int[] diff = new int[n];
    	Queue<Integer> queue = new LinkedList<Integer>();
    	List<int[]> list = new ArrayList<int[]>();
    	for(int i=0;i<n;i++){
    		diff[i] = gas[i] - cost[i];
    		if(diff[i]>=0){
    			list.add(new int[]{diff[i],i});
    		}
    	}
    	int size = list.size();
    	if(size>0){
    		quicksort(list,0,size-1);
    	}
    	for(int i=0;i<size;i++){
    		queue.offer(list.get(i)[1]);
    	}
    	int ans = -1;
    	while(!queue.isEmpty()){
    		int cur = queue.poll();
    		int tmp = 0;
    		int pos = cur-1;
    		boolean isFind = true;
    		for(int i=1;i<=n;i++){
    			pos++;
    			if(pos==n){
    				pos = 0;
    			}
    			tmp+=diff[pos];
    			if(tmp<0){
    				isFind = false;
    				break;
    			}
    		}
    		if(isFind){
    			ans = cur;
    			break;
    		}
    	}
        return ans;
    }
    
    public static void main(String[] args) {
		int[] gas = new int[]{4};
		int[] cost = new int[]{5};
		System.out.println(new Solution().canCompleteCircuit(gas, cost));
	}
}