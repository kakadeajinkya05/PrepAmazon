package backtracking;

public class QueenPlacingAlgo {

	static class Position {
		int row;
		int col;
		public Position(int x ,int y){
			row = x;
			col = y;
		}
	}

	public static void main(String[] args) {

		int numberOfQueue = 4;
		Position [] pos = solveNQueenProblem(numberOfQueue);
		for(int i=0;i<pos.length;i++){
			System.out.println(pos[i].row + " "+ pos[i].col);
		}
	}

	private static Position[] solveNQueenProblem(int n) {
		Position[] pos = new Position[n];
		boolean possible = findQueenPosition(0, n, pos);
		if (possible) {
			return pos;
		}
		return new Position[0];
	}

	private static boolean findQueenPosition(int row, int n, Position[] pos) {
		if (row == n) {
			return true;
		}
		for (int col = 0; col < n; col++) {
			boolean safePlace = true;
			for (int q = 0; q < row; q++) {
				if( pos[q].row - pos[q].col == row - col || 
					pos[q].row + pos[q].col == row + col ||
					pos[q].col == col){
					safePlace = false;
				}
			}
			if(safePlace){
				pos[row] = new Position(row, col);
				if(findQueenPosition(row+1, n, pos)){
					return true;
				}
			}
		}

		return false;
	}

}
