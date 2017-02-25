
public class Solution {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode removeElements(ListNode head, int val) {
		while(head!=null && head.val==val){
			head = head.next;
		}
		ListNode cur = head;
		while(cur!=null){
			ListNode nextNode = cur.next;
			if(nextNode==null) break;
			if(nextNode.val==val){
				cur.next = nextNode.next;
				continue;
			}
			cur = nextNode;
		}
		return head;
	}
}