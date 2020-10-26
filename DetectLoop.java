import java.util.*;
 
public class LinkedList {
 
    static Node head; 
 
    static class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
 
    static public void push(int new_data)
    {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    static int detectLoop(Node h)
    {
    	if(h == null)
            return 0;

        Node slow, fast; 

        slow = fast = h; 

        while(true) {

            slow = slow.next; 

            if(fast.next != null)
                fast = fast.next.next;
            else
                return 0; 

            if(slow == null || fast == null)
                return 0;

            if(slow == fast) 
                return 1;
        }

    }
 
    /* Driver program to test above function before and after a loop is present */
    public static void main(String[] args)
    {
        LinkedList llist = new LinkedList();
 
        llist.push(20);
        llist.push(4);
        llist.push(15);
        llist.push(10);
        
        if (detectLoop(head) == 1)
            System.out.println("Loop found");
        else
            System.out.println("No Loop");
 
        /* Create loop for testing */
        llist.head.next.next.next.next = llist.head;
 
        if (detectLoop(head) == 1)
            System.out.println("Loop found");
        else
            System.out.println("No Loop");
    }
}