import java.util.Stack;

public class Solution {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		int len = s.length();
		char c;
		for (int i = 0; i < len; i++) {
			switch (s.charAt(i)) {
			case '{':
				stack.push('{');
				break;
			case '}':
				if(stack.isEmpty()) return false;
				c = stack.pop();
				if(c!='{') return false;
				break;
			case '[':
				stack.push('[');
				break;
			case ']':
				if(stack.isEmpty()) return false;
				c = stack.pop();
				if(c!='[') return false;
				break;
			case '(':
				stack.push('(');
				break;
			case ')':
				if(stack.isEmpty()) return false;
				c = stack.pop();
				if(c!='(') return false;
				break;
			}
		}
		if(stack.isEmpty()) return true;
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().isValid("()[]{}"));
	}
}