
public class Solution {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode swapPairs(ListNode head) {
		if (head == null)
			return head;
		if (head.next == null)
			return head;
		ListNode nextNode = head.next;
		head.next = swapPairs(nextNode.next);
		nextNode.next = head;
		return nextNode;
	}
	
	public static void main(String[] args){
		Solution obj = new Solution();
		ListNode l1 = obj.new ListNode(1);
		ListNode l2 = obj.new ListNode(2);
		
		ListNode l3 = obj.new ListNode(3);
		ListNode l4 = obj.new ListNode(4);
		l1.next = l2; l2.next = l3; l3.next =l4;
		
		ListNode head = obj.swapPairs(l1);
		while(head!=null){
			System.out.println(head.val);
			head = head.next;
		}
	}
}