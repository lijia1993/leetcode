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
	
	public boolean dfs_left(TreeNode root,int val){
		if(root==null) return true;
		if(root.val>=val) return false;
		if(root.left!=null){
			if(root.left.val>val||!dfs_left(root.left,val))
				return false;
		}
		if(root.right!=null){
			if(root.right.val>val||!dfs_left(root.right,val))
				return false;
		}
		return true;
	}
	public boolean dfs_right(TreeNode root,int val){
		if(root==null) return true;
		if(root.val<=val) return false;
		if(root.left!=null){
			if(root.left.val<val||!dfs_right(root.left,val))
				return false;
		}
		if(root.right!=null){
			if(root.right.val<val||!dfs_right(root.right,val))
				return false;
		}
		return true;
	}
	
    public boolean isValidBST(TreeNode root) {
    	if(root==null) return true;
    	if(!isValidBST(root.left)){
    		return false;
    	}
    	if(!isValidBST(root.right)){
    		return false;
    	}
    	if(!dfs_left(root.left,root.val)){
    		return false;
    	}
    	if(!dfs_right(root.right,root.val)){
    		return false;
    	}
        return true;
    }
    
    public static void main(String[] args) {
		TreeNode a1 = new TreeNode(10);
		TreeNode a2 = new TreeNode(5);
		TreeNode a3 = new TreeNode(15);
		TreeNode a4 = new TreeNode(8);
		TreeNode a5 = new TreeNode(20);
		a1.left = a2;
		a1.right = a3;
		a3.left = a4;
		a3.right = a5;
		System.out.println(new Solution().isValidBST(a1));
	}
}