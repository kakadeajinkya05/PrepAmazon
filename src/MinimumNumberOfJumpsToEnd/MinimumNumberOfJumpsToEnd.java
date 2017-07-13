package MinimumNumberOfJumpsToEnd;

public class MinimumNumberOfJumpsToEnd {

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 2, 1, 4, 3, 2, 6, 7, 6, 8, 9 };
		System.out.println(minJumps(arr));
	}

	private static int minJumps(int[] arr) {
		if (arr.length <= 1) {
			return 0;
		}
		if (arr[0] == 0) {
			return -1;
		}

		int jump = 1;
		int step = arr[0];
		int maxReach = arr[0];
		for(int i=0;i<arr.length;i++){ 
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
		for (int i = 1; i < arr.length; i++) {
			System.out.println("");
			System.out.println("Stating from i="+i + " arr[i]="+arr[i] +  " jump="+jump + " maxReach="+maxReach + " step="+step );
			if (i == arr.length - 1) { // reached end of array
				return jump;
			}
			maxReach = Math.max(maxReach, i + arr[i]); // get the max reach
			System.out.println("	maxReach="+maxReach + " <  " + "(i + arr[i]) =" + (i + arr[i]));
			step--;// you have used a step
			System.out.println("	Minimizing 1 step");
			if (step == 0) { // if no more steps remianing, you need to jump
				System.out.println("	As step is zero, add a jump");
				jump++; // make a jump 
				if ( maxReach <= i) { // if maxreach is <= i then we aint going anywhere from here  
					System.out.println("	If maxreach"+ maxReach + " is <= current index "+i + " hen we willnot able to make any jump from here");
					return -1;
				}
				step = maxReach - i; // add these steps 
				System.out.println("	Step is reset to maxReach-i ("+ maxReach + " - "+i + ") =" + (maxReach-i));
			}
			System.out.println("Processed from i="+i + " arr[i]="+arr[i] +  " jump="+jump + " maxReach="+maxReach + " step="+step );	
		}

		return -1;
	}

}
