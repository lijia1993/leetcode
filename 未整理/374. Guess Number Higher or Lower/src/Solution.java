/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */
public class Solution {
	int guess(int num){
		int ans = 6;
		if(num>ans) return -1;
		if(num<ans) return 1;
		return 0;
	}
	public int guessNumber(int n) {
		int left = 1,right = n;
		while(true){
			if(left==right) return left;
			int mid = (int)(((double)(left)+(double)(right))/2);
			int result = guess(mid);
			if(result==0) return mid;
			if(result==-1){
				right = mid-1;
				continue;
			}else{
				left = mid+1;
				continue;
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(new Solution().guessNumber(10));
	}
}
