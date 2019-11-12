package LinkedList;
//package LinkedList;

public class Node {
//	member variables of class
	private int data;
	Node next;
	
//	constructor
	public Node(int data){
		this.data = data;
		next = null;
	}
	public Node() {
		this(0);	 	//call para constructor
	}
	
// 	member functions
	public void addNext(int num) {
//		create new node to add in the list
		Node newNode = new Node(num);
		newNode.next = this.next;
		this.next = newNode;
	}
	
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public int getData() {
		return data;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
