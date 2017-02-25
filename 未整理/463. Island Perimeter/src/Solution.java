public class Solution {
    public int islandPerimeter(int[][] grid) {
    	int ans = 0;
        int n = grid.length;
        if(n==0) return 0;
        int m = grid[0].length;
        for(int i=0;i<n;i++){
        	for(int j=0;j<m;j++){
        		if(grid[i][j]==1){
        			if(i>0&&grid[i-1][j]==1){
        				ans--;
        			}
        			if(j>0&&grid[i][j-1]==1){
        				ans--;
        			}
        			if(i<n-1&&grid[i+1][j]==1){
        				ans--;
        			}
        			if(j<m-1&&grid[i][j+1]==1){
        				ans--;
        			}
        			ans+=4;
        		}
        	}
        }
    	return ans;
    }
}