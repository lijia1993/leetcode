public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i=1;i<=n/2;i++){
        	int times = n+1-2*i;
        	for(int j=1;j<=times;j++){
        		int minBound = i-1;
        		int maxBound = minBound + times;
        		
        		int x = i-1;
        		int y = i-1;
        		int direction = 0;
        		int[][] direct = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        		int lastNum = matrix[x][y];
        		while(direction==0){
        			int newx = x + direct[direction][0];
        			int newy = y + direct[direction][1];
        			if(newx>maxBound){
        				direction++;
        				break;
        			}
        			matrix[x][y] = matrix[newx][newy];
        			x = newx;
        			y = newy;
        		}
        		while(direction==1){
        			int newx = x + direct[direction][0];
        			int newy = y + direct[direction][1];
        			if(newy>maxBound){
        				direction++;
        				break;
        			}
        			matrix[x][y] = matrix[newx][newy];
        			x = newx;
        			y = newy;
        		}
        		while(direction==2){
        			int newx = x + direct[direction][0];
        			int newy = y + direct[direction][1];
        			if(newx<minBound){
        				direction++;
        				break;
        			}
        			matrix[x][y] = matrix[newx][newy];
        			x = newx;
        			y = newy;
        		}
        		while(direction==3){
        			int newx = x + direct[direction][0];
        			int newy = y + direct[direction][1];
        			if(newy<minBound){
        				direction++;
        				break;
        			}
        			matrix[x][y] = matrix[newx][newy];
        			x = newx;
        			y = newy;
        		}
        		matrix[x][y+1] = lastNum;
        	}
        }
    }
    
    public static void main(String[] args) {
		int[][] matrix = new int[][]{
//			{1,2,3,4},
//			{5,6,7,8},
//			{9,10,11,12},
//			{13,14,15,16}
			{1,2,3},
			{4,5,6},
			{7,8,9}
		};
		new Solution().rotate(matrix);
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
}