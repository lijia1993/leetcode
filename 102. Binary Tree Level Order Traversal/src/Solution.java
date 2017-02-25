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

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root==null) return result;
		List<TreeNode> queueNode = new ArrayList<TreeNode>();
		List<Integer> queueDepth = new ArrayList<Integer>();
		queueNode.add(root);
		queueDepth.add(1);
		int pos = -1;
		while(pos+1<queueNode.size()){
			pos++;
			TreeNode curNode = queueNode.get(pos);
			int curDepth = queueDepth.get(pos);
			if(curNode.left!=null){
				queueNode.add(curNode.left);
				queueDepth.add(curDepth+1);
			}
			if(curNode.right!=null){
				queueNode.add(curNode.right);
				queueDepth.add(curDepth+1);
			}
		}
		int len = queueNode.size(),startPos=0;
		for(int i=0;i<len-1;i++){
			if(i+1<len&&queueDepth.get(i)==queueDepth.get(i+1)){
				continue;
			}
			List<Integer> tmp = new ArrayList<Integer>();
			for(int j=startPos;j<=i;j++){
				tmp.add(queueNode.get(j).val);
			}
			result.add(tmp);
			startPos = i+1;
		}
		List<Integer> tmp = new ArrayList<Integer>();
		for(int j=startPos;j<len;j++){
			tmp.add(queueNode.get(j).val);
		}
		if(tmp!=null)result.add(tmp);
		return result;
	}
	
	public static void main(String[] args) {
		Solution obj = new Solution();
		TreeNode node1 = obj.new TreeNode(1);
		TreeNode node2 = obj.new TreeNode(2);
		node1.left=node2;
		obj.levelOrder(node1);
	}
}
