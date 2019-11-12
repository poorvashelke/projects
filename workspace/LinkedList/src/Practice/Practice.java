/*
 * Remove duplicates from a sorted linked list
 * For example if the linked list is 11->11->11->21->43->43->60 
 * then removeDuplicates() should convert the list to 11->21->43->60.
 */

package Practice;

public class Practice {
	Node head;  // head of list

/* Linked list Node*/
	class Node
	{
	    int data;
	    Node next;
	    Node(int d) {data = d; next = null; }
	}
	
	void removeDuplicates()
	{
	    Node current = head;
	
	    /* Pointer to store the next pointer of a node to be deleted*/
	    Node nextNode;
	
	    if (head == null)    
	        return;
	
	    while (current.next != null) {
	
	        /*Compare current node with the next node */
	        if (current.data == current.next.data) {
	            nextNode = current.next.next;
	            current.next = null;
	            current.next = nextNode;
	        }
	        else // advance if no deletion
	           current = current.next;
	    }
	}
                 

	public void push(int new_data)
	{
	    /* 1 & 2: Allocate the Node &
	              Put in the data*/
	    Node new_node = new Node(new_data);
	
	    /* 3. Make next of new Node as head */
	    new_node.next = head;
	
	    /* 4. Move the head to point to new Node */
	    head = new_node;
	}
	
	 void printList()
	 {
	     Node temp = head;
	     while (temp != null)
	     {
	        System.out.print(temp.data+" ");
	        temp = temp.next;
	     }  
	     System.out.println();
	 }
	 
	 /*Merge two sorted linked lists
	  * For example if the first linked list a is 5->10->15 and the other linked list b is 2->3->20, 
	  * then SortedMerge() should return a pointer to the head node of the merged list 2->3->5->10->15->20.
	  */
	 public Node mergeTwoLists(Node list1, Node list2) {
		    Node head = new Node(0);
		    Node p = head;
		 
		    while(list1!=null||list2!=null){
		        if(list1!=null&&list2!=null){
		            if(list1.data < list2.data){
		                p.next = list1;
		                list1=list1.next;
		            }else{
		                p.next=list2;
		                list2=list2.next;
		            }
		            p = p.next;
		        }else if(list1==null){
		            p.next = list2;
		            break;
		        }else if(list2==null){
		            p.next = list1;
		            break;
		        }
		    }
		 
		    return head.next;
		}
	
	public static void main(String args[])
	{
	    Practice llist = new Practice();
	    llist.push(20);
	    llist.push(13);
	    llist.push(13);
	    llist.push(11);
	    llist.push(11);
	    llist.push(11);
	     
	    System.out.println("List before removal of duplicates");
	    llist.printList();
	     
	    llist.removeDuplicates();
	     
	    System.out.println("List after removal of elements");
	    llist.printList();
	    
	    System.out.println("------------------------------------");
	    Practice list1 = new Practice();
	    list1.push(2);
	    list1.push(6);
	    list1.push(10);
	    list1.push(11);
	    Practice list2 = new Practice();
	    list2.push(5);
	    list2.push(13);
	    
	    //mergeTwoLists(list1, list2);
	    
	    
	}
} 
