import java.util.Stack;

public class Solution {
	public int lengthLongestPath(String input) {
		input = input + "\n";
		int ans = 0;
		int input_len = input.length();
		String curString = "";
		int curLength = 0;
		int t_count = 0;
		Stack<String> stringSk = new Stack<String>();
		Stack<Integer> thSk = new Stack<Integer>();
		thSk.push(-1);
		for (int i = 0; i < input_len; i++) {
			if (input.charAt(i) == '\t') {
				t_count++;
				curString = "";
				continue;
			}
			if (input.charAt(i) == '\n') {
				while(thSk.peek()>=t_count){
					curLength-= stringSk.peek().length();
					thSk.pop();
					stringSk.pop();
				}
				stringSk.push(curString);
				thSk.push(t_count);
				curLength = curLength + curString.length();
				if(curString.contains(".")){
					ans = Math.max(ans, curLength+thSk.peek());
				}
				curString = "";
				t_count = 0;
				continue;
			}
			curString = curString + input.charAt(i);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		String s = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
		System.out.println(new Solution().lengthLongestPath(s));
	}
}