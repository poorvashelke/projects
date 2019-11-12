/* Detect Loop in LinkedList
 * Floyd’s Cycle-Finding Algorithm:
This is the fastest method. Traverse linked list using two pointers.
 Move one pointer by one and other pointer by two. If these pointers meet at some node then there is a loop.
 If pointers do not meet then linked list doesn’t have loop.
 */
package Practice;

public class DetectLoop {

	Node head;  // head of list
	  
    /* Linked list Node*/
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
  
    /* Inserts a new Node at front of the list. */
    public void push(int new_data)
    {
        Node newNode = new Node(new_data);
        newNode.next = head; // to link head to new node which we are creating
        /*  Move the head to point to new Node */
        head = newNode;
    }
 
    int detectLoop()
    {
        Node first = head, second = head;
        while (first != null && second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
            if (first == second) {
                System.out.println("Found loop");
                return 1;
            }
        }
        System.out.println("Loop not found");
        return 0;
    }
 
    /* Drier program to test above functions */
    public static void main(String args[])
    {
        DetectLoop list = new DetectLoop();
 
        list.push(2);
        list.push(14);
        list.push(25);
        list.push(10);
         
        /*Create loop for testing */
//        list.head.next.next.next = list.head;
 
        list.detectLoop();
    }
} 

