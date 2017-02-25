
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        int n = 0;
        while(head!=null){
        	n++;
        	head = head.next;
        }
        if(k<=1||n==0||n<k){
        	head = newHead.next;
            newHead = null;
        	return head;
        }
        int m = n/k;
        ListNode cur = newHead.next;
        ListNode next = cur.next;
        ListNode tmpHead = newHead;
        for(int i=1;i<=m;i++){
        	for(int j=1;j<=k-1;j++){
        		cur.next = next.next;
        		next.next = tmpHead.next;
        		tmpHead.next = next;
        		next = cur.next;
        	}
        	tmpHead = cur;
        	cur = cur.next;
        	if(cur==null){
        		break;
        	}
        	next = cur.next;
        }
        head = newHead.next;
        newHead = null;
    	return head;
    }
}