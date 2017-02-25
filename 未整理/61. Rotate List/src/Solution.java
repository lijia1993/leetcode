/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return head;
    	int n = 1;
        ListNode tail = head;
        while(tail.next!=null){
        	n++;
        	tail=tail.next;
        }
        k = k % n;
        k = n-k;
        ListNode cur = head;
        for(int i=1;i<k;i++){
        	cur = cur.next;
        }
        tail.next = head;
        head = cur.next;
        cur.next = null;
    	return head;
    }
}