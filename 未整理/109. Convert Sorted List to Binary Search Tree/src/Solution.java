/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	public TreeNode dfs(ListNode head,int n){
		int step = (n-1)/2;
		ListNode tmpNode = head;
		for(int i=1;i<=step;i++){
			tmpNode = tmpNode.next;
		}
		TreeNode rootNode = new TreeNode(tmpNode.val);
		if(step>0){
			rootNode.left = dfs(head,step);
		}
		if(n-step-1>0){
			rootNode.right = dfs(tmpNode.next,n-step-1);
		}
		return rootNode;
	}
	
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        int n=0;
        ListNode tmpNode = head;
        while(tmpNode!=null){
        	n++;
        	tmpNode = tmpNode.next;
        }
        return dfs(head,n);
    }
}