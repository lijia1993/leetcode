import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int calDis(int[] point1,int[] point2){
		int x = (point1[0]-point2[0]);
		int y = (point1[1]-point2[1]);
		return x*x+y*y;
	}
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        int[][] dis = new int[n][n];
        for(int i=0;i<n;i++){
        	for(int j=0;j<n;j++){
        		dis[i][j] = calDis(points[i],points[j]);
        	}
        }
    	int ans = 0;
    	for(int i=0;i<n;i++){
    		Map<Integer,Integer> map = new HashMap<Integer,Integer>(n);
    		for(int j=0;j<n;j++){
    			Integer x = map.get(dis[i][j]);
    			if(x==null){
    				map.put(dis[i][j],1);
    			}
    			else{
    				map.put(dis[i][j], x+1);
    			}
    		}
    		for(Integer tmp:map.keySet()){
    			int x = map.get(tmp);
    			ans+= x*(x-1);
    		}
    	}
    	return ans;
    }
    
    public static void main(String[] args) {
    	Solution obj = new Solution();
    	int[][] points = new int[][]{{0,0},{1,0},{-1,0},{0,1},{0,-1}};
    	System.out.println(obj.numberOfBoomerangs(points));
	}
}