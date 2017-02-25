
public class Solution {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseList(ListNode head) {
		if (head == null)
			return head;
		if (head.next == null)
			return head;
		ListNode nextNode = head.next;
		ListNode newHead = reverseList(nextNode);
		nextNode.next = head;
		head.next = null;
		return newHead;
	}

	public boolean isPalindrome(ListNode head) {
		if(head==null) return true;
		if(head.next==null) return true;
		ListNode slowP = head;
		ListNode fastP = head;
		while(true){
			if(fastP.next==null)break;
			if(fastP.next.next==null){
				slowP = slowP.next;
				fastP = fastP.next;
				break;
			}
			slowP = slowP.next;
			fastP = fastP.next.next;
		}
		ListNode newHead = reverseList(slowP);
		while(true){
			if(head.val!=newHead.val){
				return false;
			}
			head = head.next;
			newHead = newHead.next;
			if(head==null||newHead==null){
				break;
			}
			if(head==newHead){
				break;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Solution obj = new Solution();
		ListNode node1 = obj.new ListNode(1);
		ListNode node2 = obj.new ListNode(2);
		ListNode node3 = obj.new ListNode(1);
		node1.next=node2;
		node2.next=node3;
		System.out.println(obj.isPalindrome(node1));
	}
}