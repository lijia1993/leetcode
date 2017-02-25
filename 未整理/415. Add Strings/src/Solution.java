
public class Solution {
	public String addStrings(String num1, String num2) {
		int len1 = num1.length();
		int len2 = num2.length();
		StringBuilder sb1;
		StringBuilder sb2;
		if(len1>len2){
			sb1 = new StringBuilder(num2).reverse();
			sb2 = new StringBuilder(num1).reverse();
			int tmp = len1;
			len1 = len2;
			len2 = tmp;
		}
		else{
			sb1 = new StringBuilder(num1).reverse();
			sb2 = new StringBuilder(num2).reverse();
		}
		StringBuilder result = new StringBuilder();
		int carry = 0;
		for(int i=0;i<len1;i++){
			int cur;
			cur = sb1.charAt(i)-'0'+sb2.charAt(i)-'0'+carry;
			carry = cur / 10;
			cur = cur%10;
			result.append(String.valueOf(cur));
		}
		for(int i=len1;i<len2;i++){
			int cur;
			cur = sb2.charAt(i)-'0'+carry;
			carry = cur / 10;
			cur = cur%10;
			result.append(String.valueOf(cur));
		}
		if(carry>0){
			result.append(String.valueOf(carry));
		}
		return result.reverse().toString();
	}
}
