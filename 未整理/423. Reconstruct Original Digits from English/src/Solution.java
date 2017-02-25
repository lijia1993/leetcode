import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public String originalDigits(String s) {
        String[] digitsEnglish = new String[]{"zero","one",
        		"two","three",
        		"four","five",
        		"six","seven",
        		"eight","nine"};
        int[] hashTable = new int[26];
        int len_s = s.length();
        for(int i=0;i<len_s;i++){
        	hashTable[s.charAt(i)-'a']++;
        }
        List<Integer> list = new ArrayList<Integer>();
        int[] order = new int[]{0,4,2,6,8,7,5,3,9,1};
        for(int k=0;k<=9;k++){
        	int i = order[k];
        	while(true){
        		String word = digitsEnglish[i];
            	boolean flags = true;
            	int len_word = word.length();
            	for(int j=0;j<len_word;j++){
            		if(hashTable[word.charAt(j)-'a']<=0){
            			flags=false;
            		}
           			hashTable[word.charAt(j)-'a']--;
            	}
            	if(flags){
            		list.add(i);
            		continue;
            	}
            	else{
            		for(int j=0;j<len_word;j++){
                		hashTable[word.charAt(j)-'a']++;
                	}
            		break;
            	}
        	}
        }
        int size = list.size();
        int[] nums = new int[size];
        for(int i=0;i<size;i++){
        	nums[i] = list.get(i);
        }
        Arrays.sort(nums);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<size;i++){
        	sb.append(nums[i]+"");
        }
    	return sb.toString();
    }
    public static void main(String[] args) {
		String s = "zeroonetwothreefourfivesixseveneightnine";
		Solution obj = new Solution();
		System.out.println(obj.originalDigits(s));
	}
}