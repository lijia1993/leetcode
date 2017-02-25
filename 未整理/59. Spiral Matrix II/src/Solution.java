public class Solution {
    public int[][] generateMatrix(int n) {
    	int matrix[][] = new int[n][n];
    	int x=0,y=-1;
		int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int[] bounds = new int[]{n-1,n-1,0,1};
		int direct = 0;
		for(int i=0;i<n*n;i++){
			x = x+directions[direct][0];
			y = y+directions[direct][1];
			matrix[x][y] = i+1;
			switch(direct){
			case 0:
				if(y==bounds[direct]){
					bounds[direct]--;
					direct++;
				}
				break;
			case 1:
				if(x==bounds[direct]){
					bounds[direct]--;
					direct++;
				}
				break;
			case 2:
				if(y==bounds[direct]){
					bounds[direct]++;
					direct++;
				}
				break;
			case 3:
				if(x==bounds[direct]){
					bounds[direct]++;
					direct=0;
				}
				break;
			}
		}
    	return matrix;
    }
    
    public static void main(String[] args) {
		new Solution().generateMatrix(0);
	}
}