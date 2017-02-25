import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {

	public ListNode head;
	
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
    }
    
	/** Returns a random node's value. */
	public int getRandom() {
//		int i = 1, ans = head.val;
//		ListNode curNode = head;
//		while (true) {
//			if (curNode.next == null)
//				break;
//			i++;
//			curNode = curNode.next;
//			int random = (int) (Math.random() * i) + 1;
//			if (random == 1)
//				ans = curNode.val;
//		}
		ListNode curNode = head;
		List<Integer> tmp = new ArrayList<Integer>();
		int ct = -1;
		while(true){
			if(curNode==null) break;
			ct++;
			tmp.add(curNode.val);
			curNode = curNode.next;
		}
		int random = (int) (Math.random() * (ct+1));
		return tmp.get(random);
	}

    public static void main(String[] args) {
    	ListNode head = new ListNode(1);
    	head.next = new ListNode(2);
    	head.next.next = new ListNode(3);
    	head.next.next.next = new ListNode(4);
    	Solution obj = new Solution(head);
    	int param_1 = obj.getRandom();
    	System.out.println(param_1);
	}
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */