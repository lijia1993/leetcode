/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null){
        	return head;
        }
        ListNode evenHead = head.next;
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        while(true){
        	if(evenNode.next==null){
        		oddNode.next = evenHead;
        		break; 
        	}
        	oddNode.next = evenNode.next;
        	oddNode = oddNode.next;
        	if(oddNode.next==null){
        		oddNode.next = evenHead;
        		evenNode.next = null;
        		break;
        	}
        	evenNode.next = oddNode.next;
        	evenNode = evenNode.next;
        }
    	return head;
    }
    
    public static void main(String[] args) {
    	ListNode l1 =new ListNode(1);
    	ListNode l2 =new ListNode(2);
    	ListNode l3 =new ListNode(3);
    	ListNode l4 =new ListNode(4);
    	l1.next = l2;
    	l2.next = l3;
    	l3.next = l4;
    	new Solution().oddEvenList(l1);
	}
}