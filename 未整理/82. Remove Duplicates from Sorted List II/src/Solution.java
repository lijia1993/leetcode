/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
    	ListNode newHead =  new ListNode(0);
    	newHead.next = head;
    	ListNode cur = newHead;
    	while(cur!=null){
    		ListNode tmp = cur;
    		cur = cur.next;
    		if(cur==null||cur.next==null){
    			break;
    		}
    		if(cur.next!=null&&cur.next.val!=cur.val){
    			continue;
    		}
    		while(cur.next!=null&&cur.next.val==cur.val){
    			cur = cur.next;
    		}
    		tmp.next = cur.next;
    		cur = tmp;
    	}
    	head = newHead.next;
    	newHead.next = null;
        return head;
    }
    public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(1);
		ListNode l4 = new ListNode(2);
		ListNode l5 = new ListNode(3);
//		ListNode l6 = new ListNode(4);
//		ListNode l7 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
//		l5.next = l6;
//		l6.next = l7;
		new Solution().deleteDuplicates(l1);
	}
}