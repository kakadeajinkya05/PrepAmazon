package LinkedList;

/*
 * 
 * Input : 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10
 * k = 3
 * Output : 2 -> 5 -> 8 ->3 -> 6 -> 9 -> 4 -> 7 -> 10
 */
public class LinkedListUpdate {

	static MyList root;

	static class MyList {
		int value;
		MyList next;

		public MyList(int val) {
			value = val;
			next = null;
		}

		@Override
		public String toString() {
			return "MyList [value=" + value + "]";
		}

	}

	public static void main(String[] args) {

		MyList one = new MyList(1);
		MyList two = new MyList(2);
		root = one;
		MyList three = new MyList(3);
		MyList four = new MyList(4);
		MyList five = new MyList(5);
		MyList six = new MyList(6);
		MyList seven = new MyList(7);
		MyList eight = new MyList(8);
		MyList nine = new MyList(9);
		MyList ten = new MyList(10);
		MyList eleven = new MyList(11);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = six;
		six.next = seven;
		seven.next = eight;
		eight.next = nine;
		nine.next = ten;
		ten.next = eleven;

		MyList head = root;
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		int k = 3;
		modifyList(root, k);
		System.out.println();
		while (root != null) {
			System.out.print(root.value + " ");
			root = root.next;
		}

	}

	private static void modifyList(MyList root, int k) {

		MyList[] list = new MyList[k];

		int index = 0;
		MyList next = null;
		while (root != null && index < k) {
			next = root.next;
			if (list[index] == null) {
				list[index] = root;
				root.next = null;
			} else {
				MyList ele = list[index];
				while (ele.next!=null) {
					ele = ele.next;
				}
				ele.next = root;
				root.next = null;
			}
			root = next;
			index++;
			if (index == k) {
				index = 0;
			}
		}
		MyList prev = null;
		for (int i = 0; i < k; i++) {
			MyList ele = list[i];
			if (prev != null) {
				prev.next = ele;
			}
			while (ele != null) {
				prev = ele;
				ele = ele.next;
			}
		}

	}
}
