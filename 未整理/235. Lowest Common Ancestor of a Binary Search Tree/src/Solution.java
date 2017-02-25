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
	
	public List<TreeNode> findNode(TreeNode curNode,TreeNode aimNode,List<TreeNode> path){
		if(curNode==aimNode){
			path.add(curNode);
			return path;
		}
		if(curNode.left==null&&curNode.right==null){
			return null;
		}
		if(curNode.left!=null){
			int curSize = path.size();
			path.add(curNode);
			if(findNode(curNode.left,aimNode,path)!=null){
				return path;
			}
			path.remove(curSize);
		}
		if(curNode.right!=null){
			int curSize = path.size();
			path.add(curNode);
			if(findNode(curNode.right,aimNode,path)!=null){
				return path;
			}
			path.remove(curSize);
		}
		return null;
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		List<TreeNode> p_list = new ArrayList<TreeNode>();
		List<TreeNode> q_list = new ArrayList<TreeNode>();
		findNode(root,p,p_list);
		findNode(root,q,q_list);
		int len_min = Math.min(p_list.size(), q_list.size());
		TreeNode ans = root;
		for(int i=len_min-1;i>=0;i--){
			if(p_list.get(i)==q_list.get(i)){
				ans = p_list.get(i);
				break;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Solution obj = new Solution();
		TreeNode node1 = obj.new TreeNode(6);
		TreeNode node2 = obj.new TreeNode(2);
		TreeNode node3 = obj.new TreeNode(8);
		TreeNode node4 = obj.new TreeNode(0);
		TreeNode node5 = obj.new TreeNode(4);
		TreeNode node6 = obj.new TreeNode(7);
		TreeNode node7 = obj.new TreeNode(9);
		TreeNode node8 = obj.new TreeNode(3);
		TreeNode node9 = obj.new TreeNode(5);
		node1.left = node2; node1.right = node3;
		node2.left = node4; node2.right = node5;
		node5.left = node8; node5.right = node9;
		node3.left = node6; node3.right = node7;
		System.out.println(obj.lowestCommonAncestor(node1, node4, node9).val);
	}
}