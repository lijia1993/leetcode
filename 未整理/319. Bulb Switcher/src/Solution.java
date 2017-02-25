public class Solution {
//    public int bulbSwitch(int n) {
//        int ans = 0;
//        for(int i=1;i<=n;i++){
//        	boolean flags = false;
//        	for(int j=1;j<=i;j++){
//        		if(i%j==0) flags = !flags;
//        	}
//        	if(flags) ans++;
//        }
//        return ans;
//    }
	public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
    
    
    public static void main(String[] args) {
    	Solution obj = new Solution();
    	for(int i=1;i<=100;i++){
    		System.out.println(i+"="+obj.bulbSwitch(i));
    	}
		
	}
}