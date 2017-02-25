
public class Solution {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lenA = 0;
		int lenB = 0;
		ListNode tmp = headA;
		while(tmp!=null){
			tmp = tmp.next;
			lenA++;
		}
		tmp = headB;
		while(tmp!=null){
			tmp = tmp.next;
			lenB++;
		}
		int diff;
		if(lenA<lenB){
			tmp = headA;
			headA = headB;
			headB = tmp;
			diff = lenA;
			lenA = lenB;
			lenB = diff;
		}
		diff = lenA - lenB;
		for(int i=1;i<=diff;i++){
			headA = headA.next;
		}
		while(true){
			if(headA==headB||headA==null) return headA;
			headA = headA.next;
			headB = headB.next;
		}
	}
}