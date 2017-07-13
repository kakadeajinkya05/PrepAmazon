package medianFinder;

import Tree.TreeClass;
import Tree.TreeClass.Node;

public class MedianInBST {
	
	static class KNode{
		int k;
		public KNode(int n){
			k=n;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeClass tree = TreeClass.getTree();
		double median = findMedian(tree.head);
		System.out.println(median);
	}

	private static  double  findMedian(Node head) {
		int nodeCount = getNodeCount(head);
		System.out.println("total Node count ="+nodeCount);
		if(nodeCount % 2 == 0){
			int num1 = getKthNode(head,new KNode(nodeCount/2 +1)).data;
			int num2 = getKthNode(head,new KNode(nodeCount/2)).data;
			System.out.println("Num1 & 2 ="+ num1 + " + " + num2);
			return ( num1 + (double)num2)/2;
		}
		int num1 = getKthNode(head,new KNode(nodeCount/2 +1)).data;
		System.out.println("Num1  ="+ num1  + " at location "+(nodeCount/2 +1));
		return num1;
	}

	private static Node getKthNode(Node root, KNode k) {
		if(root == null){
			return null;
		}
		Node right = getKthNode(root.right, k);
		if(right != null){
			return right;
		}
		if(--k.k == 0){
			return root;
		}
		return getKthNode(root.left, k);
	}

	private static int getNodeCount(Node root) {
		if(root == null){
			return 0;
		}
		return getNodeCount(root.left)+ 1 + getNodeCount(root.right);
	}	
}
