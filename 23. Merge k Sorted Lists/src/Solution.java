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
    
    public ListNode findLastNode(ListNode node){
    	while(node.next!=null){
    		node = node.next;
    	}
    	return node;
    }
	
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if(len==0) return null;
        int preIndex = 0;
        while(preIndex<len&&lists[preIndex]==null){
        	preIndex++;
        }
        if(preIndex==len){
        	return null;
        }
        ListNode startNode = lists[preIndex];
        for(int i=preIndex+1;i<len;i++){
        	if(lists[i]!=null){
        		findLastNode(lists[preIndex]).next = lists[i];
        		preIndex = i;
        	}
        }
        return sortList(startNode);
    }
    
    public static void main(String[] args) {
    	ListNode l1 = new ListNode(1);
		ListNode[] lists = new ListNode[]{null,l1};
		new Solution().mergeKLists(lists);
	}
}