package MaxDistance;

public class EditDistance {

	static void findDistance(char[] str1, char[] str2) {
		int dis[][] = new int[str1.length + 1][str2.length + 1];
		for (int i = 0; i <= str1.length; i++) {
			for (int j = 0; j <= str2.length; j++) {
				if (i == 0) {
					dis[i][j] = j;
				}
				else if (j == 0) {
					dis[i][j] = i;
				}
				else if(str1[i-1] == str2[j-1]){
					dis[i][j] = dis[i-1][j-1] ;
				}
				else{
					dis[i][j] = 1+ Math.min(Math.min(dis[i-1][j], dis[i][j-1]),dis[i-1][j-1]);
				}
			}
		}
		System.out.println(dis[str1.length][str2.length]);
	}

	public static void main(String[] args) {
		String str1 = "CART";
		String str2= "MARCH";
		findDistance(str1.toCharArray(), str2.toCharArray());
	}
}
