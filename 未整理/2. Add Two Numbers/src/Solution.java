public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0),tail = head;
        int carry = 0;
        while(l1!=null&&l2!=null){
        	int this_dit = l1.val + l2.val + carry;
        	carry = this_dit / 10;
        	this_dit = this_dit % 10;
        	ListNode newNode = new ListNode(this_dit);
       		tail.next = newNode;
        	tail = newNode;
        	l1 = l1.next;
        	l2 = l2.next;
        }
        while(l1!=null){
        	int this_dit = l1.val + carry;
        	carry = this_dit / 10;
        	this_dit = this_dit % 10;
        	ListNode newNode = new ListNode(this_dit);
        	tail.next = newNode;
        	tail = newNode;
        	l1 = l1.next;
        }
        while(l2!=null){
        	int this_dit = l2.val + carry;
        	carry = this_dit / 10;
        	this_dit = this_dit % 10;
        	ListNode newNode = new ListNode(this_dit);
        	tail.next = newNode;
        	tail = newNode;
        	l2 = l2.next;
        }
        if(carry>0){
        	ListNode newNode = new ListNode(carry);
        	tail.next = newNode;
        	tail = newNode;
        }
        ListNode ans = head.next;
        head = null;
        return ans;
    }
}