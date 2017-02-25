import java.util.HashMap;
import java.util.Map;

public class Solution {
    public void setZeroes(int[][] matrix) {
    	int n = matrix.length;
        int m = matrix[0].length;
    	Map<Integer,Boolean> iList = new HashMap<Integer,Boolean>(n);
        Map<Integer,Boolean> jList = new HashMap<Integer,Boolean>(m);
        for(int i=0;i<n;i++){
        	for(int j=0;j<m;j++){
        		if(matrix[i][j]==0){
        			iList.put(i, true);
        			jList.put(j, true);
        		}
        	}
        }
        for(int i=0;i<n;i++){
        	if(iList.get(i)!=null){
        		for(int j=0;j<m;j++){
        			matrix[i][j]=0;
        		}
        	}
        }
        for(int j=0;j<m;j++){
        	if(jList.get(j)!=null){
        		for(int i=0;i<n;i++){
        			matrix[i][j]=0;
        		}
        	}
        }
    }
}