public class Solution {
	public int calRestNum(TreeNode root, int restNum){
		if(root==null) return 0;
		int ans = 0;
		if(root.val==restNum) ans++;
		ans+=calRestNum(root.left,restNum-root.val);
		ans+=calRestNum(root.right,restNum-root.val);
		return ans;
	}
	public int pathSum(TreeNode root, int sum) {
    	if(root==null) return 0;
		int ans = 0;
		ans+=calRestNum(root,sum);
		ans+=pathSum(root.left,sum);
		ans+=pathSum(root.right,sum);
		return ans;
    }
}