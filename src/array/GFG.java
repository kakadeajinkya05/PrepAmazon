package array;

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	private static int size = 5;
	private static int arr[] = { 7, 1, 5, 3, 9 };
	private static int time[] = new int[size];
	private static int times = 1;

	public static void main(String[] args) {
		// Scanner sc = new Scanner(System.in);
		// int times = sc.nextInt();
		while (times > 0) {
			/*
			 * int size = sc.nextInt(); int arr [] = new int [size]; int time []
			 * = new int[size]; for(int i=0;i<size;i++){ arr[i] = sc.nextInt();
			 * time[i] =0; }
			 */
			for (int i = 0; i < size; i++) {
				time[i] = 0;
			}
			int iteration = -1;
			while (iteration <= size) {
				iteration++;
				int noofmatch=0;
				for(int i=0;i<size;i++){
					if(time[i]==iteration){
						noofmatch++;
					}
				}
				if(noofmatch==1){
					break;
				}
				for (int i = 0; i < size; i++) {
					if (time[i] == iteration) {
						int j=i + 1;
						for (; j < size; j++) {
							if (time[j] == iteration) {
								break;
							}
						}
						if (j == size) {
							time[i] = iteration + 1;
						} else {
							if (arr[i] > arr[j]) {
								time[i] = iteration + 1;
							} else {
								time[j] = iteration + 1;
							}
							i = j;
						}
					}
				}
			}
			times--;
		}
		// sc.close();
	}
}