import java.util.ArrayList;
import java.util.List;

public class MinStack {
	List<Integer> list;
	int pos;
	
    /** initialize your data structure here. */
    public MinStack() {
        list = new ArrayList<Integer>();
        pos=-1;
    }
    
    public void push(int x) {
        list.add(x);
        pos++;
    }
    
    public void pop() {
        list.remove(pos);
        pos--;
    }
    
    public int top() {
        return list.get(pos);
    }
    
    public int getMin() {
    	int tmp = list.get(0);
    	for(int num:list){
    		if(num<tmp) tmp=num;
    	}
        return tmp;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */