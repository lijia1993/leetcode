public class Solution {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null && l2==null) return l1;
		if(l1==null && l2!=null) return l2;
		if(l1!=null && l2==null) return l1;
		ListNode head = (l1.val>=l2.val)?(l2):(l1);
		while(l1!=null&&l2!=null){
			if(l1.val<l2.val){
				while(l1.val<=l2.val){
					if(l1.next==null) break;
					if(l1.next.val>l2.val)break;
					l1 = l1.next;
				}
				ListNode tmp = l1.next;
				l1.next = l2;
				l1 = tmp;
			}
			else{
				while(l1.val>=l2.val){
					if(l2.next==null) break;
					if(l2.next.val>l1.val)break;
					l2 = l2.next;
				}
				ListNode tmp = l2.next;
				l2.next = l1;
				l2 = tmp;
			}
		}
		return head;
	}
	
	public static void main(String[] args){
		Solution obj = new Solution();
		ListNode l11 = obj.new ListNode(2);
		ListNode l12 = obj.new ListNode(4);
		l11.next = l12; 
		ListNode l21 = obj.new ListNode(1);
		ListNode l22 = obj.new ListNode(3);
		ListNode l23 = obj.new ListNode(5);
		ListNode l24 = obj.new ListNode(7);
		l21.next = l22; l22.next =l23; l23.next =l24;
		
		ListNode head = obj.mergeTwoLists(l11, l21);
		while(head!=null){
			System.out.println(head.val);
			head = head.next;
		}
	}
}