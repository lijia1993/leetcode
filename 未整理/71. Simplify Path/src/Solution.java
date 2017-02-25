import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        Stack<String> subpath = new Stack<String>();
        path = path + "/";
        int len = path.length();
        String baseString = "";
        for(int i=1;i<len;i++){
        	if(path.charAt(i)=='/'){
        		if(baseString.length()==0||baseString.equals(".")){
        			baseString = "";
        			continue;
        		}
        		if(baseString.equals("..")){
        			baseString = "";
        			if(subpath.isEmpty()){
        				continue;
        			}
        			subpath.pop();
        			continue;
        		}
        		subpath.add(baseString);
        		baseString = "";
        	}
        	else{
        		baseString = baseString + path.charAt(i);
        	}
        }
        if(subpath.isEmpty()){
        	return "/";
        }
        Stack<String> tmp = new Stack<String>();
        while(!subpath.isEmpty()){
        	tmp.add(subpath.pop());
        }
        StringBuilder sb = new StringBuilder();
        while(!tmp.isEmpty()){
        	sb.append("/");
        	sb.append(tmp.pop());
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().simplifyPath("/..."));
		System.out.println(new Solution().simplifyPath("/home/"));
		System.out.println(new Solution().simplifyPath("/a/./b/../../c/"));
	}
}