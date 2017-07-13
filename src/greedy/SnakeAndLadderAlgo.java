package greedy;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadderAlgo {

	static class QItem {
		int pos;
		int numOFThrows;

		public QItem(int x, int y) {
			pos = x;
			numOFThrows = y;
		}
	}

	public static void main(String[] args) {
		int N = 30;
		int moves[] = new int[N];
		for (int i = 0; i < N; i++)
			moves[i] = -1;

		// Ladders
		moves[2] = 21;
		moves[4] = 7;
		moves[10] = 25;
		moves[19] = 28;

		// Snakes
		moves[26] = 0;
		moves[20] = 8;
		moves[16] = 3;
		moves[18] = 6;

		int minThrows = findMinThrows(N, moves);
		System.out.println(minThrows);
	}

	private static int findMinThrows(int n, int moves[]) {

		int visited[] = new int[n];
		for (int i = 0; i < visited.length; i++) {
			visited[i] = 0;
		}
		Queue<QItem> q = new LinkedList<>();
		QItem qi = new QItem(0, 0);
		q.add(qi);
		while (!q.isEmpty()) {
			qi = q.remove();
			int pos = qi.pos;
			if (pos == n - 1) {
				break;
			}
			for (int i = pos + 1; i <= pos + 6 && i < n; i++) {
				if (visited[i] == 0) {
					QItem ele = new QItem(i, qi.numOFThrows + 1);
					if (moves[i] != -1) {
						ele.pos = moves[i];
					}
					q.add(ele);
					visited[i] = 1;
				}
			}
		}
		return qi.numOFThrows;
	}

}
