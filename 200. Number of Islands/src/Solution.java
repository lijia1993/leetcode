public class Solution {
	public void dfs(char[][] grid,int x,int y,boolean[][] map){
		map[x][y] = true;
		if(x-1>=0&&grid[x-1][y]=='1'&&map[x-1][y]==false){
			dfs(grid,x-1,y,map);
		}
		if(y-1>=0&&grid[x][y-1]=='1'&&map[x][y-1]==false){
			dfs(grid,x,y-1,map);
		}
		if(x+1<grid.length&&grid[x+1][y]=='1'&&map[x+1][y]==false){
			dfs(grid,x+1,y,map);
		}
		if(y+1<grid[0].length&&grid[x][y+1]=='1'&&map[x][y+1]==false){
			dfs(grid,x,y+1,map);
		}
	}
	
    public int numIslands(char[][] grid) {
    	int ans = 0;
    	int n = grid.length;
    	if(n==0) return 0;
    	int m = grid[0].length;
    	boolean[][] map = new boolean[n][m];
    	for(int i=0;i<n;i++){
    		for(int j=0;j<m;j++){
    			if(grid[i][j]=='0'){
    				map[i][j]=true;
    				continue;
    			}
    			if(map[i][j]==false){
    				dfs(grid,i,j,map);
    				ans++;
    			}
    		}
    	}
        return ans;
    }
}