package LinkedList;

public class LinkedListLoop {

	class MyList{
		int value;
		MyList next;
	}
	
	public static void main(String[] args) {
		
	}
	
	void findLoop(MyList head){
		MyList slow = head;
		MyList fast = head;
		
		while(slow != null &&  fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				break;
			}
		}
		if(slow == fast){
			slow = head;
			while(slow != fast.next){
				slow = slow.next;
				fast = fast.next;
			}
			fast.next = null;
		}
	}

}
