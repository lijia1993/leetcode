public class Solution {
    public int maximalRectangle(char[][] matrix) {
    	int n = matrix.length;
    	if(n==0) return 0;
    	int m = matrix[0].length;
    	int[][] left1 = new int[n][m];
    	int[][] up1 = new int[n][m];
    	left1[0][0] = matrix[0][0] - '0';
    	up1[0][0] = matrix[0][0] - '0';
    	for(int i=1;i<n;i++){
    		left1[i][0] = matrix[i][0] - '0';
    		if(matrix[i][0]=='1'){
    			up1[i][0] = up1[i-1][0]+1;
    		}
    	}
    	for(int i=1;i<m;i++){
    		up1[0][i] = matrix[0][i] - '0';
    		if(matrix[0][i]=='1'){
    			left1[0][i] = left1[0][i-1]+1;
    		}
    	}
    	for(int i=1;i<n;i++){
    		for(int j=1;j<m;j++){
    			if(matrix[i][j]=='1'){
    				up1[i][j] = up1[i-1][j] + 1;
    				left1[i][j] = left1[i][j-1] +1;
    			}
    		}
    	}
    	int ans = 0;
    	for(int i=0;i<n;i++){
    		for(int j=0;j<m;j++){
    			int tmpAns = 0;
    			if(up1[i][j]>=left1[i][j]){
    				int minHeight = up1[i][j];
    				for(int k=0;k<left1[i][j];k++){
    					minHeight = Math.min(minHeight, up1[i][j-k]);
    					if((k+1)*minHeight<tmpAns){
//    						break;
    						continue;
    					}
    					tmpAns = (k+1)*minHeight;
    					ans = Math.max(ans, tmpAns);
    				}
    			}
    			else{
    				int minWidth = left1[i][j];
    				for(int k=0;k<up1[i][j];k++){
    					minWidth = Math.min(minWidth, left1[i-k][j]);
    					if((k+1)*minWidth<tmpAns){
//    						break;
    						continue;
    					}
    					tmpAns = (k+1)*minWidth;
    					ans = Math.max(ans, tmpAns);
    				}
    			}
    		}
    	}
        return ans;
    }
    
    public static void main(String[] args) {
//		char[][] matrix = new char[][]{
//			"10100".toCharArray(),"10111".toCharArray(),"11111".toCharArray(),"10010".toCharArray()
//		};
		char[][] matrix = new char[][]{
			"1111".toCharArray(),"1111".toCharArray(),"1111".toCharArray()
		};
		System.out.println(new Solution().maximalRectangle(matrix));
	}
}