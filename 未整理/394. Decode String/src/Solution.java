import java.util.Stack;

public class Solution {
	public int getNumsDits(int x){
		if(x==0) return 1;
		int ans = 0;
		while(x>0){
			ans++;
			x/=10;
		}
		return ans;
	}
	
    public String decodeString(String s) {
        Stack<Integer> stack_times = new Stack<Integer>();
        Stack<Integer> pos = new Stack<Integer>();
        int num = 0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
				num = num *10 + s.charAt(i) - '0';
				continue;
			}
			if(s.charAt(i)=='['){
				stack_times.push(num);
				pos.push(i+1);
				num = 0;
				continue;
			}
			if(s.charAt(i)==']'){
				int times = stack_times.pop();
				int start_pos = pos.pop();
				String base_string = s.substring(start_pos, i);
				StringBuilder new_string = new StringBuilder(base_string.length()*times);
				for(int j=1;j<=times;j++){
					new_string.append(base_string);
				}
				StringBuilder new_s = new StringBuilder();
				new_s.append(s.substring(0,start_pos-1-getNumsDits(times)));
				new_s.append(new_string);
				new_s.append(s.substring(i+1));
				s = new_s.toString();
				i = start_pos-getNumsDits(times) + new_string.length() - 2;
			}
		}
        return s;
    }
    
    public static void main(String[] args) {
    	String s = "3[a]2[bc]";
    	s = "2[abc]3[cd]ef";
		System.out.println(new Solution().decodeString(s));
	}
}