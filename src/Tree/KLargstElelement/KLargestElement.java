package Tree.KLargstElelement;

import Tree.TreeClass;
import Tree.TreeClass.Node;

public class KLargestElement {
	static  class KNode{
		int nodeCount;
		Node node;
		public KNode(int k) {
			nodeCount = k;
			node =null;
		}
	}

	public static void main(String[] args) {
		TreeClass bst = TreeClass.getTree();
		KNode knode = new KNode(1);
		//findKElement(bst.head,knode,false);
		Node num = reverseInorderTraversal(bst.head,knode);
		System.out.println(num.data);
	}
	
	static Node reverseInorderTraversal(Node head, KNode knode ){
		if(head==null){ 
			return null;
		}
		Node right = reverseInorderTraversal(head.right, knode);
		if(right != null){
			return right;
		}
		if(-- knode.nodeCount == 0){
			return head;
		}
		return reverseInorderTraversal(head.left, knode);
		
	}

	private static void findKElement(Node head, KNode knode, boolean found) {
		if(head == null || knode.node!= null){
			return ;
		}
		findKElement(head.right, knode,found);
		knode.nodeCount --;
		if( knode.nodeCount == 0){
			knode.node = head;
		}
		findKElement(head.left, knode,found);
	}

}
