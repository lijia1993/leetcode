import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
    	int count = -1;
    	int[] ans = new int[numCourses];
    	int[] indegree = new int[numCourses];
    	List<List<Integer>> edgeList = new ArrayList<List<Integer>>();
    	for(int i=0;i<numCourses;i++){
    		edgeList.add(new ArrayList<Integer>());
    	}
    	for(int i=0;i<prerequisites.length;i++){
    		indegree[prerequisites[i][0]]++;
    		edgeList.get(prerequisites[i][1]).add(prerequisites[i][0]);
    	}
    	Queue<Integer> queue = new LinkedList<Integer>();
    	for(int i=0;i<numCourses;i++){
    		if(indegree[i]==0){
    			queue.offer(i);
    		}
    	}
    	while(!queue.isEmpty()){
    		int cur = queue.poll();
    		ans[++count] = cur;
    		int edgeNum = edgeList.get(cur).size();
    		for(int i=0;i<edgeNum;i++){
    			indegree[edgeList.get(cur).get(i)]--;
    			if(indegree[edgeList.get(cur).get(i)]==0){
    				queue.offer(edgeList.get(cur).get(i));
    			}
    		}
    	}
    	for(int i=0;i<numCourses;i++){
    		if(indegree[i]!=0){
    			return new int[0];
    		}
    	}
        return ans;
    }
}