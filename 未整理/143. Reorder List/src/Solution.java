/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
    	if(head==null||head.next==null||head.next.next==null) return;
        ListNode fastNode = head;
        ListNode slowNode = head;
        while(true){
        	fastNode = fastNode.next.next;
        	slowNode = slowNode.next;
        	if(fastNode.next==null){
        		break;
        	}
        	if(fastNode.next.next==null){
        		fastNode = fastNode.next;
        		ListNode tmp = slowNode;
        		slowNode = slowNode.next;
        		tmp.next = null;
        		break;
        	}
        }
        
        ListNode prev = null;
        ListNode curr = slowNode;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        
        ListNode ltor = head;
        ListNode rtol = prev;
        while(true){
        	ListNode nextLnode = ltor.next;
        	ListNode nextRnode = rtol.next;
        	ltor.next = rtol;
        	rtol.next = nextLnode;
        	if(nextLnode==nextRnode){
        		break;
        	}
        	ltor = nextLnode;
        	rtol = nextRnode;
        	if(ltor.next==null){
        		ltor.next = rtol;
        		break;
        	}
        }
    }
    
    public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		new Solution().reorderList(l1);
	}
}