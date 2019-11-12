package BinaryTree;

public class BinaryTree {
	private BinaryNode root;
	
	public BinaryTree() {
		root = null;
	}
	public BinaryTree(int value) {
		this.root = new BinaryNode(value);
	}
//	in-order:     left -> root -> right
	public void inOrder() {
		inOrderHelper(root);
	}
	private void inOrderHelper(BinaryNode current) {
		if(current == null) {
			return;
		}
		inOrderHelper(current.getLeft());
		System.out.print(current.getData()+",");
		inOrderHelper(current.getRight());
//		System.out.println(current.getData());
	}
	
//	Pre-Order :     root -> left -> right
	public void preOrder() {
		preOrderHelper(root);
	}
	private void preOrderHelper(BinaryNode current) {
		if(current == null) {
			return;
		}
		System.out.print(current.getData()+",");
		preOrderHelper(current.getLeft());
		preOrderHelper(current.getRight());
	}
//	Post-order :     left -> right -> root
	public void postOrder() {
		postOrderHelper(root);
	}
	private void postOrderHelper(BinaryNode current) {
		if(current == null) {
			return;
		}
		postOrderHelper(current.getLeft());
		postOrderHelper(current.getRight());
		System.out.print(current.getData()+",");
	}
	
//	chk wheather its a binary search tree or not    
//	T(n) = O(n)
	public boolean isBST() {
		return isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private boolean isBSTHelper(BinaryNode current, int min, int max) {
		if(current == null) {
			return true;
		}
		if(current.getData() < min || current.getData() > max) {
			return false;
		}
		return isBSTHelper(current.getLeft(), min, current.getData()) && 
				isBSTHelper(current.getRight(), current.getData(), max);
	}
	
//	class binary node fn in-order
	public void nodeInorder() {
		if(root == null) {
			return;
		}
		root.inOrder();
	}
	
//	height = no of edges in the longest path
	public int height() {
		return heightHelper(root);
	}
	
	public int heightHelper(BinaryNode current) {
		if (current == null) {
			return -1;
		}
		return Math.max(heightHelper(current.getLeft()), heightHelper(current.getRight())) + 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tree = new BinaryTree(5);
		tree.root.addLeft(4);
		tree.root.addRight(6);
		tree.root.getLeft().addRight(3);
		tree.root.getRight().addRight(9);
		System.out.print("\n Pre-order:");
		tree.preOrder();
		System.out.print("\n In-order:");
		tree.inOrder();
		System.out.print("\nNode class In-order:");
		tree.nodeInorder();
		System.out.print("\n Post-order:");
		tree.postOrder();
		
		BinaryTree tree1 = new BinaryTree(100);
		tree1.root.addLeft(50);
		tree1.root.addRight(60);
		tree1.root.getLeft().addRight(30);
		tree1.root.getRight().addRight(90);
		System.out.println("\n" + tree1.isBST());
		
		BinaryTree tree2 = new BinaryTree(100);
		tree2.root.addLeft(50);
		tree2.root.addRight(110);
		tree2.root.getLeft().addLeft(40);
		tree2.root.getLeft().addRight(55);
		tree2.root.getRight().addRight(120);
		System.out.println("\n" + tree2.isBST());
		
	}

}
