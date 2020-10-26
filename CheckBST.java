import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;
	
	Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class BinarySearchTree {
	public static boolean checkBST(Node root) {
		return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean check(Node node, int min, int max) {
		if (node == null) {
			return true;
		}

		if (node.data < min || node.data > max) {
			return false;
		}

		return check(node.left, min, node.data - 1) && check(node.right, node.data + 1, max);
	}
	
	// this main method's purpose is to test two different trees
	public static void main(String[] args) {
		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.left = new Node(4);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right = new Node(9);
        boolean isIt = checkBST(root);
        if (isIt == false) {
        	System.out.println("No");
        }
        else {
        	System.out.println("Yes");
        }
        
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(5);
        root2.left.left = new Node(4);
        root2.left.right = new Node(6);
        root2.right.left = new Node(8);
        boolean isIt2 = checkBST(root2);
        if (isIt2 == false) {
        	System.out.println("No");
        }
        else {
        	System.out.println("Yes");
        }
	}
}