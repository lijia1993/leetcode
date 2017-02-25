public class Solution {
	
    public boolean isValidSudoku(char[][] board) {
    	//check rows
    	for(int i=0;i<9;i++){
    		int[] hashTable = new int[10];
    		for(int j=0;j<9;j++){
    			if(board[i][j]=='.')continue;
    			int num = board[i][j]-'0';
    			if(hashTable[num]!=0){
    				return false;
    			}
    			hashTable[num]++;
    		}
    	}
    	//check columns
    	for(int j=0;j<9;j++){
    		int[] hashTable = new int[10];
    		for(int i=0;i<9;i++){
    			if(board[i][j]=='.')continue;
    			int num = board[i][j]-'0';
    			if(hashTable[num]!=0){
    				return false;
    			}
    			hashTable[num]++;
    		}
    	}
    	//check box
    	int[][] op = new int[][]{{0,0},{0,3},{0,6},{3,0},{3,3},{3,6},{6,0},{6,3},{6,6}};
    	for(int k=0;k<=8;k++){
    		int[] hashTable = new int[10];
    		for(int i=0;i<3;i++){
    			for(int j=0;j<3;j++){
    				int x = i+op[k][0];
    				int y = j+op[k][1];
    				if(board[x][y]=='.')continue;
        			int num = board[x][y]-'0';
        			if(hashTable[num]!=0){
        				return false;
        			}
        			hashTable[num]++;
    			}
    		}
    	}
        return true;
    }
    
    public static void main(String[] args) {
		Solution obj = new Solution();
		char[][] ch = new char[9][9];
		String[] a = new String[]{"....5..1.",".4.3.....",".....3..1","8......2.","..2.7....",".15......",".....2...",".2.9.....","..4......"};
		for(int i=0;i<9;i++){
			ch[i] = a[i].toCharArray();
		}
		System.out.println(obj.isValidSudoku(ch));
	}
}