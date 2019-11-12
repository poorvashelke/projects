//package LinkedList;
//import LinkedList.Node;

public class Queue {
	private Node head;
	private Node tail;
	
	public Queue() {
		head = null;
		tail = null;
	}
//	add remove isempty size print
	public void add(int data) {
//		case1 empty Queue
		if(isEmpty()) {
			head = new Node(data);	
			tail = head;
			return;
		}
//		case2 non empty adding data at the end
		tail.addNext(data);
		tail = tail.getNext();
	}
	
	public boolean remove() {
//		case1 empty Queue
		if(isEmpty()) {
			return false;		//nothing to remove
		}
//		case2.1 non empty Queue
		head = head.getNext();
		
//		case2.2 only one Node in Queue
		if(isEmpty()) {		//at this point head is null
			tail = null;
		}
		return true;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public int size() {
		int count = 0;
		for(Node current = head; current != null; current = current.getNext()) {
			count++;
		}
		return count;
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		for(Node current = head; current != null; current = current.getNext()) {
			result.append(current.getData());
			result.append(',');
		}
		return result.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue q = new Queue();
		System.out.println(q.isEmpty());
		System.out.println(q.size());
		System.out.println(q.remove());
		q.add(2);
		q.add(4);
		System.out.println(q.tail.getData());
		System.out.println(q.isEmpty());
		System.out.println(q.remove());
		System.out.println(q.size());
		q.add(5);
		q.add(3);
		System.out.println(q.toString());
		System.out.println(q.size());
	}

}
