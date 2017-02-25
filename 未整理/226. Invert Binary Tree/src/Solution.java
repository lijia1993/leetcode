
public class Solution {

	public TreeNode invertTree(TreeNode root) {
		TreeNode tmpNode;
		if (root != null) {
			if (root.left == null && root.right == null)
				return root;
			else if (root.left == null && root.right != null) {
				root.left = invertTree(root.right);
				root.right = null;
				return root;
			} else if (root.left != null && root.right == null) {
				root.right = invertTree(root.left);
				root.left = null;
				return root;
			} else {
				tmpNode = invertTree(root.left);
				root.left = invertTree(root.right);
				root.right = tmpNode;
				return root;
			}
		}
		return root;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {

	}

}
