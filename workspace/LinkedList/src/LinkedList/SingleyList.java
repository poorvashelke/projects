package LinkedList;

public class SingleyList {
	static Node head;
	
	public SingleyList() {
		this.head = null;
	}
//  add delete size search empty print
	public boolean isEmpty() {		// T(n) = 1
		return head == null;
	}
	public void addFirst(int num) {
		if (head == null) {
			head = new Node(num);
			return;  	//  if we dont write, it will print num 2 times     OutPut: 1,1
		}
		Node current = new Node(num);
		current.setNext(head);
		this.head = current;
		
	}
	public void addLast(int num) {	// T(n) = O(n)
		if (head == null) {		// for empty list
			head = new Node(num);
			return;
		}
//		add new node after the last node
		Node current;
		for(current = head; current.getNext() != null; current = current.getNext());
		current.addNext(num);
	}

	/* reverse the linked list -------------------*/
   public Node reverse(Node data) {
        Node prev = null;
        Node current = data;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev; 	// to make reverse connection ie 1->2->4 then by this we make Null<-1<-2<-4
            prev = current;
            current = next;
        }
        data = prev;
        return data;
    }
	public int size() {		// T(n) = O(n)
		int count = 0;
		Node current = head;
		while ( current != null) {
			count++;
			current = current.getNext();
		}
		return count;
	}
	public boolean isPresent(int key) {		// T(n) = O(n)
		for(Node current = head; current != null; current = current.getNext()) {
			if(key == current.getData()) {
				return true;
			}
		}
		return false;
	}
	
	public void insertAt(int position, int value) {
		int count = 1;
//		case 0: Empty linked list
		/*Not Needed bec its been taken care in case 1
		 * if (head == null) { 		
			addFirst(value);
		OR	Node newNode = new Node(value);
		head = newNode;
			return;
		}*/
//		Case 1: inserting at the beginning,  changing head
		if (position == 1) {		
			addFirst(value);
			/*Node newNode = new Node(value);
			newNode.setNext(head);
			head = newNode;  */
			return;
		}
//		case 2: inserting anywhere(except 1) in the linked list
		Node current = head;
		while(current != null) {		// bec to print at end of linked list
			count++;
			if(count == position) {
				Node newNode = new Node(value);
				newNode.setNext(current.getNext());
				current.setNext(newNode);
			}
			current = current.getNext();
		}
	}
	
	
//	Sort Linked List
	public void print() {
		for(Node current = head; current != null; current = current.getNext()){
			System.out.print(current.getData() + ",");
		}
		System.out.println();
	}
	public void printRecursion() {
		printHelper(head);
	}
	public void  printHelper(Node current) {
		if(current == null) {
			return;
		}
		System.out.print(current.getData()+",");
		printHelper(current.getNext());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleyList list = new SingleyList();
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		list.addLast(1);
		list.print();
		list.addLast(4);
		list.addLast(6);
		list.addFirst(2);
		list.print();
		System.out.println(list.isEmpty());
		System.out.println(list.size());
		System.out.println(list.isPresent(3));
		System.out.println(list.isPresent(2));
		System.out.println(list.isPresent(0));
		System.out.println("-------------------------------");
		SingleyList list2 = new SingleyList();
		list2.addFirst(0);
		list2.print();
		list2.addLast(4);
		list2.print();
		list2.addFirst(-1);
		list2.print();
		System.out.println("-------------------------------");
		System.out.println("testing insert at");
		SingleyList list3 = new SingleyList();
		list3.insertAt(1, 2);
		list3.print();
		list3.insertAt(1, 3);
		list3.print();
		list3.insertAt(2, 0);
		list3.print();
		list3.insertAt(4, 4);
		list3.print();
		System.out.println("recursion");
		list3.printRecursion();
		System.out.println("-------------------------------");
		System.out.println("Reverse Linked List is:");
//		to store values of reverse linked list write:   head =
		head = list3.reverse(head);
		list3.print();
		System.out.println("-------------------------------");
	}

}
