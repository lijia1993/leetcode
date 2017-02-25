import java.util.ArrayList;
import java.util.List;

public class Solution {
	public void solve(List<String> result,int cur,int n,char[] ch,int rest_left,int rest_right){
		if(cur==n*2-1){
			ch[cur] = ')';
			result.add(String.valueOf(ch));
			return;
		}
		if(rest_left==rest_right){
			ch[cur] = '(';
			if(rest_left>0){
				solve(result, cur+1,n,ch,rest_left-1,rest_right);
			}
			return;
		}
		else{
			ch[cur] = '(';
			if(rest_left>0){
				solve(result, cur+1,n,ch,rest_left-1,rest_right);
			}
			ch[cur] = ')';
			if(rest_right>0){
				solve(result, cur+1,n,ch,rest_left,rest_right-1);
			}
		}
	}
	
	
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        char[] sol = new char[n*2];
        solve(result,0,n,sol,n,n);
        return result;
    }
    public static void main(String[] args) {
		Solution obj = new Solution();
		obj.generateParenthesis(3);
	}
}