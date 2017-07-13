package Tree;

public class TreeClass {

	public static Node head;
	public static  TreeClass getTree(){
    	TreeClass bst = new TreeClass();
    	Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node nine = new Node(9);
        Node ten = new Node(10);
        Node e11 = new Node(11);
        Node e12 = new Node(12);
        Node e13 = new Node(13);
        Node e14 = new Node(14);
        Node e15 = new Node(15);
        Node e16 = new Node(16);
        head = eight;
        head.left= four;
        head.right= e12;
        four.left=two;
        four.right=six;
        two.left=one;
        two.right=three;
        six.left = five;
        six.right=seven;
        e12.left=ten;
        e12.right=e14;
        ten.left=nine;
        ten.right=e11;
        e14.left=e13;
        e14.right=e15;
        e15.right=e16;
        return bst;
    }
	 
    public static class Node {
        public int data;
        public Node left;
        public Node right;
        public Node(int d) {
            data = d;
            left = null;
            right =null;
        }
        
    }
}
