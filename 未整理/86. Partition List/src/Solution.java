/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
    	ListNode newHead = new ListNode(0);
    	newHead.next = head;
    	ListNode p1 = newHead;
    	ListNode p2 = newHead;
    	while(p2.next!=null && p2.next.val<x){
    		p1 = p1.next;
    		p2 = p2.next;
    	}
    	while(p2.next!=null){
    		if(p2.next.val<x){
    			ListNode tmpNode = p2.next;
    			p2.next = tmpNode.next;
    			tmpNode.next = p1.next;
    			p1.next = tmpNode;
    			p1 = tmpNode;
    			continue;
    		}
    		p2 = p2.next;
    	}
    	head = newHead.next;
    	newHead.next = null;
        return head;
    }
    
    public static void main(String[] args) {
//    	ListNode l0 = new ListNode(1);
		ListNode l1 = new ListNode(4);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(2);
		ListNode l4 = new ListNode(5);
		ListNode l5 = new ListNode(2);
//		l0.next = l1;
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		new Solution().partition(l1, 3);
	}
}