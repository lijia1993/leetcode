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
	public void dfs(TreeNode root,int existSum,int[] ans){
		if(root.left==null&&root.right==null){
			ans[0] += existSum*10+root.val;
			return;
		}
		if(root.left!=null){
			dfs(root.left,existSum*10+root.val,ans);
		}
		if(root.right!=null){
			dfs(root.right,existSum*10+root.val,ans);
		}
	}
	
    public int sumNumbers(TreeNode root) {
    	if(root==null)return 0;
    	int[] ans = new int[1];
    	dfs(root,0,ans);
        return ans[0];
    }
    
    public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		t1.left = t2;
		t1.right = t3;
		System.out.println(new Solution().sumNumbers(t1));
		
	}
}