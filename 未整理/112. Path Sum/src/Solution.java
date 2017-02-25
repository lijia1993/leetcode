public class Solution {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean hasPathSum(TreeNode root, int sum) {
		if(root==null) return false;
		if(root.left==null&&root.right==null){
			if(root.val==sum) return true;
			else return false;
		}
		boolean flags = false;
		if(root.left!=null)
			flags = flags || hasPathSum(root.left,sum-root.val);
		if(root.right!=null)
			flags = flags || hasPathSum(root.right,sum-root.val);
		return flags;
	}
}