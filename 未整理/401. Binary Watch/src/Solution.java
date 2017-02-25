import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<String> readBinaryWatch(int num) {
		int[] numOfLights = new int[60];
		for(int i=0;i<60;i++){
			int x = i;
			int count = 0;
			while(x>0){
				if((x & 1) ==1) count++;
				x=x>>1;
			}
			numOfLights[i]=count;
		}
		List<String> result = new ArrayList<String>();
		for(int hourNum=0;hourNum<=4;hourNum++){
			int minNum = num-hourNum;
			if(minNum<0) break;
			for(int hour=0;hour<12;hour++){
				for(int minute=0;minute<60;minute++){
					if(numOfLights[hour]==hourNum&&numOfLights[minute]==minNum){
						StringBuilder s = new StringBuilder(String.valueOf(hour));
						s.append(":");
						if(minute<10) s.append("0");
						s.append(String.valueOf(minute));
						result.add(s.toString());
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {

	}

}
