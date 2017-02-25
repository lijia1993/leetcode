public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int tmp = n;
        int ans = 0;
        while(tmp!=0){
        	ans++;
        	tmp = tmp&(tmp-1);
        }
        return ans;
    }
}