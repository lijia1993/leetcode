import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
		int n = matrix.length;
		if(n==0) return result;
		int m = matrix[0].length;
		
		int x=0,y=-1;
		int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int[] bounds = new int[]{m-1,n-1,0,1};
		int direct = 0;
		for(int i=0;i<n*m;i++){
			x = x+directions[direct][0];
			y = y+directions[direct][1];
			result.add(matrix[x][y]);
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
		return result;
	}
	
	public static void main(String[] args) {
		int matrix[][] = new int[][]{{ 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }};
		new Solution().spiralOrder(matrix);
	}
}