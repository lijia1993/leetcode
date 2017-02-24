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
	public TreeNode dfs(int[] nums,int l,int r){
		int mid = (l+r)/2;
		TreeNode rootNode = new TreeNode(nums[mid]);
		if(mid>l){
			rootNode.left = dfs(nums,l,mid-1);
		}
		if(mid<r){
			rootNode.right = dfs(nums,mid+1,r);
		}
		return rootNode;
	}
	
    public TreeNode sortedArrayToBST(int[] nums) {
    	if(nums.length==0) return null;
    	TreeNode headNode = dfs(nums,0,nums.length-1);
        return headNode;
    }
}