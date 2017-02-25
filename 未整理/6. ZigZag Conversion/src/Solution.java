public class Solution {
    public String convert(String s, int numRows) {
    	int colsNum;
    	int len = s.length();
    	if(len==0||numRows==1)return s;
    	if(len<numRows) colsNum=1;
    	else{
    		colsNum = (numRows)*((len-numRows)/(numRows*2-2)+1);
    	}
    	int[][] map =new int[numRows][colsNum];
    	int direct = -1,x=-1,y=0;
    	for(int i=0;i<len;i++){
    		if(direct<0){
    			x++;
    			map[x][y]=i;
    			if(x==numRows-1){
    				direct=1;
    			}
    			continue;
    		}
    		else{
    			x--;
    			y++;
    			map[x][y]=i;
    			if(x==0){
    				direct=-1;
    			}
    		}
    	}
    	StringBuilder sb = new StringBuilder(len);
    	for(int i=0;i<numRows;i++){
    		for(int j=0;j<colsNum;j++){
    			if(i==0&&j==0){
    				sb.append(s.charAt(0));
    				continue;
    			}
    			if(map[i][j]==0)continue;
    			sb.append(s.charAt(map[i][j]));
    		}
    	}
        return sb.toString();
    }
}