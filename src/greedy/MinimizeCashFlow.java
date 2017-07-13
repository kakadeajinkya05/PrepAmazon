package greedy;

public class MinimizeCashFlow {
	static int N = 3;

	static int getMin(int arr[]) {
		int minInd = 0;
		for (int i = 1; i < N; i++)
			if (arr[i] < arr[minInd])
				minInd = i;
		return minInd;
	}

	static int getMax(int arr[]) {
		int maxInd = 0;
		for (int i = 1; i < N; i++)
			if (arr[i] > arr[maxInd])
				maxInd = i;
		return maxInd;
	}

	static int minOf2(int x, int y) {
		return (x < y) ? x : y;
	}

	static void minCashFlowRec(int amount[]) {
		int maxDebit = getMin(amount);
		int maxCredit = getMax(amount);
		if( amount[maxCredit] == 0  && amount[maxDebit] == 0){
			return;
		}
		int minTransaction = Math.min(amount[maxCredit], -amount[maxDebit]);
		amount[maxCredit]-=minTransaction;
		amount[maxDebit] +=minTransaction;
		System.out.println("Person " + maxDebit + "transfer "+minTransaction + " to Person "+ maxCredit);
		minCashFlowRec(amount);
	}

	static void minCashFlow(int graph[][]) {
		int amounts[] = new int[N];
		for (int currentP = 0; currentP < N; currentP++) {
			for (int fromP = 0; fromP < N; fromP++) {
				amounts[currentP]+= graph[fromP][currentP] - graph[currentP][fromP];
			}
		}
		minCashFlowRec(amounts);
	}

	public static void main(String[] args) {
		int graph[][] = { { 0, 1000, 2000 }, { 0, 0, 5000 }, { 0, 2000, 0 }, };

		// Print the solution
		minCashFlow(graph);
	}
}
