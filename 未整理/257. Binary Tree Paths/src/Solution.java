import java.util.ArrayList;
import java.util.List;

public class Solution {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public void dfs(TreeNode root,String existStr,List<String> result){
		if(root.left==null&&root.right==null){
			result.add(existStr+"->"+root.val);
			return;
		}
		if(root.left!=null){
			dfs(root.left,existStr+"->"+root.val,result);
		}
		if(root.right!=null){
			dfs(root.right,existStr+"->"+root.val,result);
		}
	}

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<String>();
		if(root==null) return result;
		if(root.left==null&&root.right==null){
			result.add(String.valueOf(root.val));
			return result;
		}
		String s=String.valueOf(root.val);
		if(root.left!=null) dfs(root.left,s,result);
		if(root.right!=null) dfs(root.right,s,result);
		return result;
	}
}
