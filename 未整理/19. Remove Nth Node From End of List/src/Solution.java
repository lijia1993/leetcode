
public class Solution {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		int len = 0;
		ListNode tmp = head;
		while(tmp!=null){
			len++;
			tmp = tmp.next;
		}
		if(len==n){
			head = head.next;
			return head;
		}
		int step = len-n;
		tmp = head;
		for(int i=1;i<step;i++){
			tmp = tmp.next;
		}
		if(tmp.next.next==null){
			tmp.next = null;
			return head;
		}
		tmp.next = tmp.next.next;
		return head;
	}
	
	public static void main(String[] args) {
		Solution obj = new Solution();
		ListNode l1 = obj.new ListNode(1);
		ListNode l2 = obj.new ListNode(2);
		ListNode l3 = obj.new ListNode(3);
		ListNode l4 = obj.new ListNode(4);
		ListNode l5 = obj.new ListNode(5);
		l1.next=l2;l2.next=l3;l3.next=l4;l4.next=l5;
		obj.removeNthFromEnd(l1, 2);
	}
}