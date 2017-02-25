
public class Solution {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 0;
		if (root.left != null && root.right == null) {
			if (root.left.left == null && root.left.right==null)
				return root.left.val;
			else
				return sumOfLeftLeaves(root.left);
		}
		if (root.left == null && root.right != null) {
			return sumOfLeftLeaves(root.right);
		}
		if (root.left.left == null && root.left.right==null)
			return root.left.val + sumOfLeftLeaves(root.right);
		else
			return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
	}

	public static void main(String[] args) {

	}

}
