package BinaryTree;

public class BinaryNode {
	private int data;
	private BinaryNode left;
	private BinaryNode right;
	
	public BinaryNode(int data){
		this.data = data;
		left = null;
		right = null;
	}

	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public BinaryNode getLeft() {
		return left;
	}
	public void addLeft(int data) {
		this.left = new BinaryNode(data);
	}
	public BinaryNode getRight() {
		return right;
	}
	public void addRight(int data) {
		this.right = new BinaryNode(data);
	}
	
//	in-order pre-order post-order is-leaf
	public void inOrder() {
		if(left != null) {
			left.inOrder();
		}
		System.out.print(data+",");
		if(right != null) {
			right.inOrder();
		}
	}
	public boolean isLeaf() {
		return (left == null &&  right == null);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryNode nodetest = new BinaryNode(5);
//		test1 : no childern
		System.out.println("Leaf node :"+nodetest.isLeaf());
//		test case 2: has only left child
		nodetest.addLeft(4);
		System.out.println("Leaf node :"+nodetest.isLeaf());
//		test case3 has only right child
		BinaryNode nodetest2 = new BinaryNode(3);
		nodetest2.addRight(6);
		System.out.println("Leaf node :"+nodetest2.isLeaf());
//		test case4 : has left and right child
		nodetest.addRight(7);
		System.out.println("Leaf node :"+nodetest.isLeaf());
	}

}
