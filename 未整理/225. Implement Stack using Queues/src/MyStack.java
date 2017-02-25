import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
	Queue<Integer> queue = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        queue.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
    	Queue<Integer> tmpQueue = new LinkedList<Integer>();
    	while(!queue.isEmpty()){
    		if(queue.size()==1){
    			queue.poll();
    			continue;
    		}
    		tmpQueue.offer(queue.poll());
    	}
    	queue = tmpQueue;
    }

    // Get the top element.
    public int top() {
    	Queue<Integer> tmpQueue = new LinkedList<Integer>();
    	int ans = 0;
    	while(!queue.isEmpty()){
    		if(queue.size()==1){
    			ans = queue.peek();
    		}
    		tmpQueue.offer(queue.poll());
    	}
    	queue = tmpQueue;
        return ans;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
    
    public static void main(String[] args) {
		MyStack obj = new MyStack();
		obj.push(1);
		System.out.println(obj.top());
	}
}