import java.util.Stack;

public class MyQueue {
	Stack<Integer> stack = new Stack<Integer>();
	
    // Push element x to the back of queue.
    public void push(int x) {
        stack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        Stack<Integer> tmpStack = new Stack<Integer>();
        while(!stack.isEmpty()){
        	tmpStack.push(stack.pop());
        }
        tmpStack.pop();
        while(!tmpStack.isEmpty()){
        	stack.push(tmpStack.pop());
        }
    }

    // Get the front element.
    public int peek() {
    	 Stack<Integer> tmpStack = new Stack<Integer>();
         while(!stack.isEmpty()){
         	tmpStack.push(stack.pop());
         }
         int ans = tmpStack.peek();
         while(!tmpStack.isEmpty()){
         	stack.push(tmpStack.pop());
         }
         return ans;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.isEmpty();
    }
}