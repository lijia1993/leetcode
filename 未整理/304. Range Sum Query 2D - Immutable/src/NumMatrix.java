public class NumMatrix {
	int[][] sum;

	public NumMatrix(int[][] matrix) {
		int rows = matrix.length;
		if(rows==0) return;
		int columns = matrix[0].length;
		sum = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (i == 0 && j == 0) {
					sum[i][j] = matrix[i][j];
					continue;
				}
				if (i == 0) {
					sum[i][j] = sum[i][j - 1] + matrix[i][j];
					continue;
				}
				if (j == 0) {
					sum[i][j] = sum[i - 1][j] + matrix[i][j];
					continue;
				}
				sum[i][j] = sum[i - 1][j] + sum[i][j - 1] + matrix[i][j] - sum[i - 1][j - 1];
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		if (row1 == 0 && col1 == 0) {
			return sum[row2][col2];
		}
		if (row1 == 0) {
			return sum[row2][col2] - sum[row2][col1 - 1];
		}
		if (col1 == 0) {
			return sum[row2][col2] - sum[row1 - 1][col2];
		}
		return sum[row2][col2] - sum[row2][col1 - 1] - sum[row1 - 1][col2] + sum[row1 - 1][col1 - 1];
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 },
				{ 1, 0, 3, 0, 5 } };
		NumMatrix numMatrix = new NumMatrix(matrix);
		
		System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
		System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
	}
}

// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);