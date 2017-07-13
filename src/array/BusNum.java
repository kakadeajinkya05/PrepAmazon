package array;

public class BusNum {

	public static void main(String[] args) {
		int sum = 1;
		int num =1;
		for(int i=2;i<=30;i++){
			num = num *2;
			sum += num;
		}
		System.out.println(sum);
		System.out.println("diff = " + (sum-100000000));
	}

}
