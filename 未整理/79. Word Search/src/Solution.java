public class Solution {
	public boolean find(char[][] board, int x, int y, int cur, String word,boolean[][] used) {
		if (cur == word.length() - 1) {
			return true;
		}
		int n = board.length;
		int m = board[0].length;
		char next_c = word.charAt(cur + 1);
		// left
		if (y > 0 && used[x][y-1] == false && board[x][y - 1] == next_c) {
			used[x][y-1] = true;
			if (find(board, x, y - 1, cur + 1, word,used)) {
				return true;
			}
			used[x][y-1] = false;
		}
		// up
		if (x > 0 && used[x-1][y] == false && board[x - 1][y] == next_c) {
			used[x-1][y] = true;
			if (find(board, x - 1, y, cur + 1, word,used)) {
				return true;
			}
			used[x-1][y] = false;
		}
		// down
		if (x + 1 < n && used[x+1][y] == false && board[x + 1][y] == next_c) {
			used[x+1][y] = true;
			if (find(board, x + 1, y, cur + 1, word,used)) {
				return true;
			}
			used[x+1][y] = false;
		}
		// right
		if (y + 1 < m && used[x][y+1] == false && board[x][y + 1] == next_c) {
			used[x][y+1] = true;
			if (find(board, x, y + 1, cur + 1, word,used)) {
				return true;
			}
			used[x][y+1] = false;
		}
		return false;
	}
	
    public boolean exist(char[][] board, String word) {
    	if(word.length()==0) return false;
    	int n = board.length;
    	int m = board[0].length;
    	boolean[][] used = new boolean[n][m];
    	for(int i=0;i<n;i++){
    		for(int j=0;j<m;j++){
    			if(board[i][j]==word.charAt(0)){
    				used[i][j] = true;
    				if(find(board,i,j,0,word,used)){
    					return true;
    				}
    				used[i][j] = false;
    			}
    		}
    	}
        return false;
    }
    
    public static void main(String[] args) {
    	char[][] board = new char[3][4];
    	board[0] = "ABCE".toCharArray();
    	board[1] = "SFCS".toCharArray();
    	board[2] = "ADEE".toCharArray();
    	System.out.println(new Solution().exist(board, "ABCB"));
	}
}