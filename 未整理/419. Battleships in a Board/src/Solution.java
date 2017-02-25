public class Solution {
	public int countBattleships(char[][] board) {
		int ans = 0;
		int n = board.length;
		int m = board[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == '.')
					continue;
				if (i > 0 && board[i - 1][j] == 'X')
					continue;
				ans++;
				int k = j;
				while (k < m && board[i][k] == 'X') {
					k++;
				}
				j = k;
			}
		}
		return ans;
	}
}