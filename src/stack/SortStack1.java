package stack;

import java.util.Stack;

public class SortStack1 {
	public static void main(String[] args) {
		int[] data = { 5, 2, 1, 9, 0, 10 };
		Stack<Integer> myStack = new Stack<Integer>();
		for (int i = 0; i < data.length; i++) {
			myStack.push(data[i]);
		}
		sortStack(myStack);
		System.out.println(myStack);
	}

	private static void sortStack(Stack<Integer> myStack) {
		if( myStack.isEmpty()) return;
		int ele = myStack.pop();
		sortStack(myStack);
		sortedInsert(myStack, ele);
	}

	private static void sortedInsert(Stack<Integer> myStack, int ele) {
		if(myStack.isEmpty() || myStack.peek() < ele){
			myStack.push(ele);
		}
		else{
			int temp = myStack.pop();
			sortedInsert(myStack, ele);
			myStack.push(temp);
		}
	}

}