package LongestCommonSubsequence;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		String str1 = "ABCDGHLQR";
		String str2 = "AEDPHR";

		int result = lcs.lcsDynamic(str1.toCharArray(), str2.toCharArray());
		System.out.println(result);
	}

	private int lcsDynamic(char[] str1, char[] str2) {
		int m = str1.length;
		int n= str2.length;
		System.out.println("array of size "+ (m+1) + " " + (n+1));
		int lcs[][] = new int[ m + 1][ n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					lcs[i][j] = 0;
				}
				else if( str1[i-1] == str2 [j-1] ){
					System.out.print(str1[i-1]);
					lcs[i][j] = lcs[i-1][j-1]+1;
				}else{
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
				}
			}
		}
		System.out.println("");
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				System.out.print(lcs[i][j]+ " ");
			}
			System.out.println("");
		}
		return lcs[str1.length][str2.length];
	}
}
