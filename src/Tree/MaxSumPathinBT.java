package Tree;
public class MaxSumPathinBT {
	static class Node
	{
		int val;
		Node left;
		Node right;
		int max_uptill;
		int max_including;
		Node(int v)
		{
			this.val = v;
		}
	}
 
	static int gMax = 0;
	public static void DFS(Node root)
	{
		int root_left_max_include = Integer.MIN_VALUE;
		int root_right_max_include = Integer.MIN_VALUE;
		int left_max_uptill = Integer.MIN_VALUE;
		int right_max_uptill = Integer.MIN_VALUE;
		if(root.left!=null)
		{
			DFS(root.left);
			root_left_max_include = root.left.max_including;
			left_max_uptill = root.left.max_uptill;
		}
		else
		{
			root_left_max_include = root.val;
			left_max_uptill = root.val;
		}
		if(root.right!=null)
		{
			DFS(root.right);
			root_right_max_include = root.right.max_including;
			right_max_uptill = root.right.max_uptill;
		}
		else
		{
			root_right_max_include = root.val;
			right_max_uptill = root.val;
		}
		root.max_including = Math.max(root_left_max_include,root_right_max_include)+root.val;
		gMax = Math.max(gMax,left_max_uptill);
		gMax = Math.max(gMax,right_max_uptill);
	}
 
	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(4);
		root.left.left = new Node(3);
		root.left.left.left = new Node(1);
		root.left.left.right = new Node(-5);
		root.left.right = new Node(-2);
		root.right = new Node(3);
		root.right.left = new Node(10);
		root.right.right = new Node(4);
		DFS(root);
		System.out.println("Max Sum Path : "+gMax);
	}
}