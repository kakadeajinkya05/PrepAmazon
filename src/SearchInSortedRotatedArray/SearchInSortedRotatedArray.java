package SearchInSortedRotatedArray;

public class SearchInSortedRotatedArray {

	// if key is present, otherwise returns -1
	static int search(int arr[], int start, int end, int key) {
		if (start > end)
			return -1;

		int mid = start + (end - start) / 2;
		if (arr[mid] == key)
			return mid;

		/* If arr[l...mid] is sorted */
		if (arr[mid] >= arr[start]) {
			// perform binary search
			if (key >= arr[start] && key <= arr[mid])
				return search(arr, start, mid - 1, key);
			return search(arr, mid + 1, end, key);
		}

		/*
		 * If arr[l..mid] is not sorted, then arr[mid... r] must be sorted
		 */
		if (key >= arr[mid] && key <= arr[end])
			return search(arr, mid + 1, end, key);

		return search(arr, start, mid - 1, key);
	}

	public static void main(String[] args) {
		int arr[] =  { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int arr2[] = { 2, 3, 4, 5, 6, 7, 8, 9, 1 };
		int arr3[] = { 3, 4, 5, 6, 7, 8, 9, 1, 2 };
		int arr4[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
		int arr5[] = { 5, 6, 7, 8, 9, 1, 2, 3, 4 };
		int arr6[] = { 6, 7, 8, 9, 1, 2, 3, 4, 5 };
		int arr7[] = { 7, 8, 9, 1, 2, 3, 4, 5, 6 };
		int arr8[] = { 8, 9, 1, 2, 3, 4, 5, 6, 7 };
		int arr9[] = { 9, 1, 2, 3, 4, 5, 6, 7, 8 };
		int n = arr.length;
		int key = 6;
		int i = search(arr, 0, n - 1, key);
		System.out.println("Index: " + i);
		i = search(arr2, 0, n - 1, key);
		System.out.println("Index: " + i);
		i = search(arr3, 0, n - 1, key);
		System.out.println("Index: " + i);
		i = search(arr4, 0, n - 1, key);
		System.out.println("Index: " + i);
		i = search(arr5, 0, n - 1, key);
		System.out.println("Index: " + i);
		i = search(arr6, 0, n - 1, key);
		System.out.println("Index: " + i);
		i = search(arr7, 0, n - 1, key);
		System.out.println("Index: " + i);
		i = search(arr8, 0, n - 1, key);
		System.out.println("Index: " + i);
		i = search(arr9, 0, n - 1, key);
		System.out.println("Index: " + i);

	}

}
