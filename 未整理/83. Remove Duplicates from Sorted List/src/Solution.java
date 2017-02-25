
public class Solution {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		if(head==null) return head;
		ListNode nextNode = head.next;
		ListNode curNode = head;
		while(nextNode!=null){
			if(curNode.val==nextNode.val){
				curNode.next = nextNode.next;
				nextNode = curNode.next;
			}
			else{
				nextNode = curNode.next.next;
				curNode = curNode.next;
			}
		}
		return head;
	}
}