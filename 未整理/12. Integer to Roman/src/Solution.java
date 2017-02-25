
public class Solution {
	
	public String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();
		int[] segNum = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
		String[] segStr = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		
		int len = segNum.length;
		int rest = num;
		for(int i=0;i<len;i++){
			while(rest>=segNum[i]){
				rest-=segNum[i];
				sb.append(segStr[i]);
			}
			if(rest==0) break;
		}
        return sb.toString();
    }
	
	public static void main(String[] args) {
		System.out.println(new Solution().intToRoman(3));
	}
}
