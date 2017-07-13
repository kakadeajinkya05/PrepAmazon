package backtracking;

public class KnightTourAlgo {

	
	public static void main(String[] args) {
		solveKnightTour();
		//solveKT();
	}

	private static void solveKnightTour() {
		int sol[][] = new int[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				sol[i][j] = -1;
			}
		}
		//int[] xmove = { 2, 2, -2, -2, 1, -1, 1, -1 };
		//int[] ymove = { 1, -1, 1, -1, 2, 2, -2, -2 };

		int xmove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int ymove[] = {1, 2, 2, 1, -1, -2, -2, -1};
        
		sol[0][0] = 0;
		if (!solveKnightTour(0, 0, 1, sol, xmove, ymove)) {
			System.out.println("Can not be solved");
		} else {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					System.out.print(sol[i][j] + " ");
				}
				System.out.println("");
			}
		}
	}

	private static boolean solveKnightTour(int x, int y, int moveCount, int[][] sol, int[] xmove, int[] ymove) {
		int nextX, nextY;
		if (moveCount == 64) {
			return true;
		}
		for (int i = 0; i < xmove.length; i++) {
			nextX = x + xmove[i];
			nextY = y + ymove[i];
			if (isSafePlace(nextX, nextY,sol)) {
				sol[nextX][nextY] = moveCount;
				if (solveKnightTour(nextX, nextY, moveCount + 1, sol, xmove, ymove)) {
					return true;
				} else {
					sol[nextX][nextY] = -1;
				}
			}
		}
		return false;
	}

	private static boolean isSafePlace(int x, int y, int[][] sol) {
		return (x >= 0 && x <= 7 && y >= 0 && y <= 7 && sol[x][y] == -1);
	}

}
