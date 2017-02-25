/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	ListNode newHead = new ListNode(0);
    	newHead.next = head;
    	ListNode curNode = newHead;
    	ListNode prepmNode = newHead;
    	ListNode mNode = null;
    	ListNode nNode = null;
    	for(int i=1;i<=n;i++){
    		curNode = curNode.next;
    		if(i==m-1){
    			prepmNode = curNode;
    		}
    		if(i==m){
    			mNode = curNode;
    		}
    		if(i==n){
    			nNode = curNode;
    		}
    	}
    	ListNode nNextNode = nNode.next;
    	nNode.next = null;
    	
    	ListNode prep = null;
    	ListNode cur = mNode;
    	while(cur!=null){
    		ListNode tmp = cur.next;
    		cur.next = prep;
    		prep = cur;
    		cur = tmp;
    	}
    	prepmNode.next = prep;
    	while(prep.next!=null){
    		prep = prep.next;
    	}
    	prep.next = nNextNode;
    	head = newHead.next;
    	newHead.next = null;
        return head;
    }
}