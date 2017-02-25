public class Solution {
    public int[] countBits(int num) {
    	int[] result = new int[num+1];
    	result[0] = 0;
    	for(int i=1;i<=num;i++){
    		int tmp = i;
            int ans = 0;
            while(tmp!=0){
            	ans++;
            	tmp = tmp&(tmp-1);
            	if(result[tmp]!=0){
            		ans+=result[tmp];
            		break;
            	}
            }
            result[i] = ans;
    	}
        return result;
    }
}