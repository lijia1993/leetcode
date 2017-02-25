public class Solution {
    public int minPathSum(int[][] grid) {
    	int rows = grid.length;
    	int columns = grid[0].length;
    	int[][] f = new int[rows][columns];
    	for(int i=0;i<rows;i++){
    		for(int j=0;j<columns;j++){
    			f[i][j] = 0x7fffffff;
    		}
    	}
    	for(int i=0;i<rows;i++){
    		for(int j=0;j<columns;j++){
    			if(i==0&&j==0){
    				f[i][j] = grid[i][j];
    			}
    			if(i-1>=0){
    				f[i][j] = Math.min(f[i][j], f[i-1][j]+grid[i][j]);
    			}
    			if(j-1>=0){
    				f[i][j] = Math.min(f[i][j], f[i][j-1]+grid[i][j]);
    			}
    		}
    	}
        return f[rows-1][columns-1];
    }
    
    public static void main(String[] args) {
		Solution obj = new Solution();
		int[][] result = new int[][]{{1,1},{2,3}};
		System.out.println(obj.minPathSum(result));
	}
}