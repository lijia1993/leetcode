import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		List<TreeNode> queueNode = new ArrayList<TreeNode>();
		List<Integer> queueNumber = new ArrayList<Integer>();
		queueNode.add(root);
		queueNumber.add(0);
		int pos = -1;
		while (pos + 1 < queueNode.size()) {
			pos++;
			TreeNode curNode = queueNode.get(pos);
			if (curNode == null)
				continue;
			if (curNode.left!=null){
				queueNode.add(curNode.left);
				queueNumber.add(queueNumber.get(pos)*2+1);
			}
			if (curNode.right!=null){
				queueNode.add(curNode.right);
				queueNumber.add(queueNumber.get(pos)*2+2);
			}
		}
		int len = queueNode.size();
		Map<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
		for(int i=0;i<len;i++){
			int key = queueNumber.get(i);
			int value = queueNode.get(i).val;
			hashMap.put(key, value);
		}
		for(int i=0;i<len;i++){
			int key = queueNumber.get(i);
			int pow = (int)(Math.log10(key+1)/Math.log10(2));
			int otherKey = (int) (3*(Math.pow(2, pow)-1)) - key;
			if(hashMap.get(key)==null&&hashMap.get(otherKey)==null){
				continue;
			}
			if(hashMap.get(key)!=null&&hashMap.get(otherKey)!=null){
				if(hashMap.get(key)!=hashMap.get(otherKey)){
					return false;
				}
				continue;
			}
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Solution obj = new Solution();
//		TreeNode node1 = obj.new TreeNode(3);
//		TreeNode node2 = obj.new TreeNode(4);
//		TreeNode node3 = obj.new TreeNode(4);
//		TreeNode node4 = obj.new TreeNode(5);
//		TreeNode node5 = obj.new TreeNode(5);
//		TreeNode node6 = obj.new TreeNode(6);
//		TreeNode node7 = obj.new TreeNode(6);
//		node1.left=node2;
//		node1.right=node3;
//		node2.left=node4;
//		node3.right=node5;
//		node4.left=node6;
//		node5.right=node7;
		
		TreeNode node1 = obj.new TreeNode(1);
		TreeNode node2 = obj.new TreeNode(2);
		TreeNode node3 = obj.new TreeNode(2);
		TreeNode node4 = obj.new TreeNode(3);
		TreeNode node5 = obj.new TreeNode(3);
		node1.left=node2;
		node1.right=node3;
		node2.right=node4;
		node3.right=node5;
		System.out.println(obj.isSymmetric(node1));
	}
}