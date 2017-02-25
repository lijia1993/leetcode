public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    	int st=0,ed=(matrix[0].length)-1;
    	while(st<=ed){
    		int mid = (st+ed)/2;
    		int val = matrix[0][mid];
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
    	int searchj = ed;
    	
    	st=0;ed=matrix.length-1;
    	while(st<=ed){
    		int mid = (st+ed)/2;
    		int val = matrix[mid][0];
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
    	int searchi = ed;
    	
    	for(int i=0;i<=searchi;i++){
    		st=0;ed=searchj;
        	while(st<=ed){
        		int mid = (st+ed)/2;
        		int val = matrix[i][mid];
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
    	}
    	
    	for(int j=0;j<=searchj;j++){
    		st=0;ed=searchi;
        	while(st<=ed){
        		int mid = (st+ed)/2;
        		int val = matrix[mid][j];
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
    	}
    	
        return false;
    }
    
    public static void main(String[] args) {
//    	int[][] matrix = new int[][]{{1,   4,  7, 11, 15},
//    	  {2,   5,  8, 12, 19},
//    	  {3,   6,  9, 16, 22},
//    	  {10, 13, 14, 17, 24},
//    	  {18, 21, 23, 26, 30}};
    	  
//    	int[][] matrix = new int[][]  {{1,3,5,7,9},{2,4,6,8,10},{11,13,15,17,19},{12,14,16,18,20},{21,22,23,24,25}};
    	int[][] matrix = new int[][]{{-1},{-1}};
    	Solution obj = new Solution();
    	System.out.println(obj.searchMatrix(matrix, 0));
	}
}