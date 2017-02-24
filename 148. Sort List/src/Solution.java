/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
	public ListNode[] quicksort(ListNode head,int n){
		if(n==1){
			return new ListNode[]{head,head};
		}
		ListNode smallNodesHead = null;
    	ListNode smallNodesTail = null;
    	ListNode bigNodesHead = null;
    	ListNode bigNodesTail = null;
    	ListNode equalNodesHead = head;
    	ListNode equalNodesTail = head;
    	ListNode tmpNode = head;
    	ListNode nextNode = head.next;
    	head.next = null;
    	int smallCount = 0;
    	int bigCount = 0;
    	int val = head.val;
    	for(int i=1;i<n;i++){
    		tmpNode = nextNode;
    		nextNode = tmpNode.next;
    		tmpNode.next = null;
    		if(tmpNode.val<val){
    			if(smallNodesHead==null){
    				smallNodesHead = tmpNode;
    				smallNodesTail = smallNodesHead;
    			}
    			else{
    				smallNodesTail.next = tmpNode;
    				smallNodesTail = smallNodesTail.next;
    			}
    			smallCount++;
    		}
    		else if(tmpNode.val>val){
    			if(bigNodesHead==null){
    				bigNodesHead = tmpNode;
    				bigNodesTail = bigNodesHead;
    			}
    			else{
    				bigNodesTail.next = tmpNode;
    				bigNodesTail = bigNodesTail.next;
    			}
    			bigCount++;
    		}
    		else{
    			equalNodesTail.next = tmpNode;
    			equalNodesTail = equalNodesTail.next;
    		}
    	}
    	ListNode newHead = null;
    	ListNode newTail = null;
    	if(smallNodesHead!=null){
    		ListNode[] leftHeadAndTail = quicksort(smallNodesHead,smallCount);
    		newHead = leftHeadAndTail[0];
    		leftHeadAndTail[1].next = equalNodesHead;
    	}
    	else{
    		newHead = equalNodesHead;
    	}
    	if(bigNodesHead!=null){
    		ListNode[] rightHeadAndTail = quicksort(bigNodesHead,bigCount);
    		newTail = rightHeadAndTail[1];
    		equalNodesTail.next = rightHeadAndTail[0];
    	}
    	else{
    		newTail = equalNodesTail;
    	}    	
		return new ListNode[]{newHead,newTail};
	}
    public ListNode sortList(ListNode head) {
    	if(head==null){
    		return head;
    	}
    	int n=0;
    	ListNode tmpNode = head;
    	while(tmpNode!=null){
    		n++;
    		tmpNode = tmpNode.next;
    	}
        return quicksort(head,n)[0];
    }
    
    public static void main(String[] args) {
		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(1);
		ListNode l5 = new ListNode(1);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		ListNode newNode = new Solution().sortList(l1);
		System.out.println(newNode.val);
	}
}