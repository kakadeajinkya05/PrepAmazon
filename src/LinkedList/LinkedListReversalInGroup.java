package LinkedList;

public class LinkedListReversalInGroup {

	class MyList {
		int value;
		MyList next;
	}

	public MyList reverseList(MyList head, int k) {
		MyList prev = null, next = null;
		int count = 0;
		while (head != null && count < k) {
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		if(next != null){
			head.next = reverseList(next, k);
		} 
		return prev;

	}

	public static void main(String[] args) {

	}

}
