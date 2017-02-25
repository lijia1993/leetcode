import java.util.ArrayList;
import java.util.List;

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
	public void dfs(List<List<Integer>> result,TreeNode curNode,int restSum,List<Integer> curList){
		if(curNode.left==null&&curNode.right==null){
			if(restSum==0){
				List<Integer> newList = new ArrayList<Integer>(curList);
				result.add(newList);
			}
			return;
		}
		if(curNode.left!=null){
			curList.add(curNode.left.val);
			dfs(result,curNode.left,restSum-curNode.left.val,curList);
			curList.remove(curList.size()-1);
		}
		if(curNode.right!=null){
			curList.add(curNode.right.val);
			dfs(result,curNode.right,restSum-curNode.right.val,curList);
			curList.remove(curList.size()-1);
		}
	}
	
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if(root==null) return result;
    	List<Integer> curList = new ArrayList<>();
    	curList.add(root.val);
    	dfs(result,root,sum-root.val,curList);
    	return result;
    }
}