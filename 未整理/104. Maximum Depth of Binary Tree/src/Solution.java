
public class Solution {
	public int maxDepth(TreeNode root) {
		if(root == null) return 0;
		if(root.left == null && root.right==null){
			return 1;
		}
		else if(root.left == null && root.right!=null){
			return maxDepth(root.right)+1;
		}
		else if(root.left != null && root.right==null){
			return maxDepth(root.left)+1;
		}
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
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
