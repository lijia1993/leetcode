public class Solution {
	public int getVal(int[][] matrix,int pos){
    	int m = matrix[0].length;
    	int i = pos/m;
    	int j = pos%m;
    	return matrix[i][j];
	}
	
    public boolean searchMatrix(int[][] matrix, int target) {
    	int st=0,ed=(matrix.length)*(matrix[0].length)-1;
    	while(st<=ed){
    		int mid = (st+ed)/2;
    		int val = getVal(matrix,mid);
    		if(val==target){
    			return true;
    		}
    		if(val>target){
    			ed = mid-1;
    		}
    		else{
    			st = mid+1;
    		}
    	}
        return false;
    }
}