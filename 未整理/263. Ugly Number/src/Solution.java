
public class Solution {

	public boolean isUgly(int num) {
		if(num<1) return false;
		int tmp = num;
		while(tmp%2==0){
			tmp=tmp/2;
		}
		while(tmp%3==0){
			tmp=tmp/3;
		}
		while(tmp%5==0){
			tmp=tmp/5;
		}
		if(tmp!=1) return false;
		return true;
	}

	public static void main(String[] args) {

	}

}
