package Tree.LCA;

import Tree.TreeClass;
import Tree.TreeClass.Node;

public class LCA {

	 public static void main(String[] args) {
	    	
	        int num1 = 1;
	        int num2 = 16;
	        TreeClass bst = TreeClass.getTree();
	        
			int dist1 = findNodeCount(bst.head,num1,0);
	        int dist2 = findNodeCount(bst.head,num2,0);
	        Node lca = findLCA(bst.head,num1,num2);
	        int lcaDist = findNodeCount(bst.head, lca.data, 0);
	        System.out.println("Root to "+num1 + " =" + dist1);
	        System.out.println("Root to "+num2 + " =" + dist2);
	        System.out.println("Root to "+lca.data + " =" + lcaDist);
	        int finalDist  = dist1 - lcaDist + dist2 -lcaDist;
	        //System.out.println((dist1 + dist2) - (2*lcaDist + 1) );
	        System.out.println("finalDist =" + finalDist );
	        
	 }

	private static Node findLCA(Node head, int n1, int n2) {
		if(head == null ){
			return null;
		}
		if(head.data == n1 || head.data == n2){
			return head;
		}
		Node left = findLCA(head.left, n1, n2);
		Node right = findLCA(head.right, n1, n2);
		if( left != null && right != null){
			return head;
		}
		if(left !=null){
			return left;
		}
		if(right!=null){
			return right;
		}
		return null;
	}

	
	private static Node findLCAForBST(Node head, int n1, int n2) {
		if(head == null ){
			return null;
		}
		if(head.data>=n1 && head.data>=n2){
			return findLCAForBST(head.left, n1, n2);
		}
		if(head.data<=n1 && head.data <= n2){
			return findLCAForBST(head.right, n1, n2);
		}
		
		return head;
	}

	private static int findNodeCount(Node head, int n, int count) {
		if(head == null ){
			return -1;
		}
		if(head.data == n){
			return count;
		}
		int leftCount = findNodeCount(head.left, n, count+1);
		return leftCount > -1 ? leftCount : findNodeCount(head.right, n, count+1);
	}
	
	


	 
	 
	        
}
