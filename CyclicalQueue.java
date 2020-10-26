import java.util.*;

public class CyclicalQueue {
	
	Stack<Integer> pushStack = new Stack<>();
    Stack<Integer> popStack = new Stack<>();

    public void push(int x) {
        pushStack.push(x);
    }

    public void pop() {
        if(popStack.isEmpty()) {
            while(!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        popStack.pop();
    }

    public int peek() {
        if(popStack.isEmpty()) {
            while(!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.peek();
    }

    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }
    
    //The following method tests all of the operations defined above
    public static void main(String[] args) { 
        Stack s = new Stack(); 
        s.push(1); 
        s.push(2); 
        s.push(3); 
  
        System.out.println("current size: " + s.size()); 
        System.out.println(s.peek()); 
        s.pop(); 
        System.out.println(s.peek()); 
        s.pop(); 
        System.out.println(s.peek()); 
  
        System.out.println("current size: " + s.size()); 
        
        System.out.println("is empty?: " + s.empty());
        
        s.push(2);
        System.out.println("current size: " + s.size()); 
        s.pop();
        s.pop();
        System.out.println("is empty?: " + s.empty());
    } 
} 