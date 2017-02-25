public class Solution {
    public String getHint(String secret, String guess) {
    	int cows = 0;
    	int bulls = 0;
    	int len = secret.length();
    	int[] hashNum = new int[10];
    	for(int i=0;i<len;i++){
    		if(secret.charAt(i)==guess.charAt(i)){
    			bulls++;
    		}
    		hashNum[secret.charAt(i)-'0']++;
    	}
    	
    	for(int i=0;i<len;i++){
    		int pos = guess.charAt(i)-'0';
    		if(hashNum[pos]>0){
    			hashNum[pos]--;
    			cows++;
    		}
    	}
    	cows -= bulls;
    	StringBuilder sb = new StringBuilder();
    	sb.append(String.valueOf(bulls));
    	sb.append("A");
    	sb.append(String.valueOf(cows));
    	sb.append("B");
        return sb.toString();
    }
}