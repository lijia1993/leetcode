public class Solution {
    public int countPrimes(int n) {
    	if(n<=1) return 0;
    	boolean[] isNotPrime = new boolean[n+1];
    	int ans = 0;
    	for(int i=2;i<n;i++){
    		if(isNotPrime[i]==false){
    			ans++;
    			for(int j=2;j<=n/i;j++){
    				isNotPrime[j*i]=true;
    			}
    		}
    	}
        return ans;
    }
}