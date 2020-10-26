import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class LevelOrder {

	public static void levelOrder(Node node) {
          Queue<Node> q = new LinkedList<Node>();
          q.add(node);
 
          while (!q.isEmpty()){
        	  	Node n = q.remove();
        	  	if (n.left != null){
        	  		q.add(n.left);
        	  	}
        	  	if (n.right != null){
        	  	q.add(n.right);
        	  	}
        	  	System.out.print(n.data+" ");
          }
	}
	
	public static Node insert(Node root, int data) {
		if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

	// main method for testing purposes, of two different inputs
    public static void main(String[] args) {
    // here is the method I would use for user input:
    //   Scanner scan = new Scanner(System.in);
    //    int t = scan.nextInt();
    //    Node root = null;
    //    while(t-- > 0) {
    //        int data = scan.nextInt();
    //        root = insert(root, data);
    //   }
    //    scan.close();
    //    levelOrder(root);
    //}	
    	Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.left = new Node(4);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right = new Node(9);
        System.out.print("The level order traversal of the tree is: ");
        levelOrder(root);
        
        Node root2 = new Node(5);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(7);
        root2.left.right = new Node(4);
        root2.right.left = new Node(6);
        root2.right.left.left = new Node(9);
        System.out.print("\nThe level order traversal of the tree is: ");
        levelOrder(root2);
    }	
}