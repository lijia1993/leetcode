
public class Solution {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseList(ListNode head) {
		if(head==null) return head;
		if(head.next==null) return head;
		ListNode nextNode = head.next;
		ListNode newHead = reverseList(nextNode);
		nextNode.next = head;
		head.next = null;
		return newHead;
	}
}