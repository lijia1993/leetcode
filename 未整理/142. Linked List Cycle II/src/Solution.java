/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
    	if(head==null) return null;
    	ListNode fastHead = head;
    	ListNode slowHead = head;
    	while(true){
    		if(fastHead.next==null||fastHead.next.next==null){
    			return null;
    		}
    		fastHead = fastHead.next.next;
    		slowHead = slowHead.next;
    		if(fastHead==slowHead){
    			slowHead = head;
    			while(true){
    				if(fastHead==slowHead){
    					return fastHead;
    				}
    				fastHead = fastHead.next;
    				slowHead = slowHead.next;
    			}
    		}
    	}
    }
}