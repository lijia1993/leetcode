
public class Solution {
	boolean isBadVersion(int version){
		if(version>=1702766719) return true; 
		return false;
	}
	public int firstBadVersion(int n) {
		int left = 1,right = n;
		while(true){
			if(left==right) return left;
			int mid = (int)(((double)(left)+(double)(right))/2);
			if(isBadVersion(mid)==true){
				right = mid;
				continue;
			}else{
				left = mid+1;
				continue;
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().firstBadVersion(2126753390));
	}
}
