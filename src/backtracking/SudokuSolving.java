package backtracking;

public class SudokuSolving {

	static int N = 9;

	static class Position {
		public Position(int row2, int col2) {
			row = row2;
			col = col2;
		}

		int row, col;
	}

	public static void main(String[] args) {
		int grid[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
				{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
		if (solveSudoku(grid) == true)
			printGrid(grid);
		else
			System.out.println("Solution not possible");
	}

	static void printGrid(int grid[][]) {
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++)
				System.out.print(grid[row][col] + " ");
			System.out.println("");
		}
	}

	private static boolean solveSudoku(int[][] grid) {
		Position pos = findUnAssignedLocation(grid);
		if (pos == null) {
			return true;
		}

		for (int num = 1; num < 10; num++) {
			if (isSafe(grid, pos.row, pos.col, num)) {
				grid[pos.row][pos.col] = num;
				if (solveSudoku(grid)) {
					return true;
				} else {
					grid[pos.row][pos.col] = 0;
				}
			}
		}
		return false;
	}

	private static Position findUnAssignedLocation(int[][] grid) {
		for (int row = 0; row < 9; row++)
			for (int col = 0; col < 9; col++)
				if (grid[row][col] == 0)
					return new Position(row, col);
		return null;
	}

	static boolean UsedInRow(int grid[][], int row, int num) {
		for (int col = 0; col < N; col++)
			if (grid[row][col] == num)
				return true;
		return false;
	}

	/*
	 * Returns a boolean which indicates whether any assigned entry in the
	 * specified column matches the given number.
	 */
	static boolean UsedInCol(int grid[][], int col, int num) {
		for (int row = 0; row < N; row++)
			if (grid[row][col] == num)
				return true;
		return false;
	}

	/*
	 * Returns a boolean which indicates whether any assigned entry within the
	 * specified 3x3 box matches the given number.
	 */
	static boolean UsedInBox(int grid[][], int boxStartRow, int boxStartCol, int num) {
		for (int row = 0; row < 3; row++)
			for (int col = 0; col < 3; col++)
				if (grid[row + boxStartRow][col + boxStartCol] == num)
					return true;
		return false;
	}

	/*
	 * Returns a boolean which indicates whether it will be legal to assign num
	 * to the given row,col location.
	 */
	static boolean isSafe(int grid[][], int row, int col, int num) {
		/*
		 * Check if 'num' is not already placed in current row, current column
		 * and current 3x3 box
		 */
		return !UsedInRow(grid, row, num) && !UsedInCol(grid, col, num)
				&& !UsedInBox(grid, row - row % 3, col - col % 3, num);
	}
}
