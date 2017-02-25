
public class Solution {
	public boolean canConstruct(String ransomNote, String magazine) {
		int[] hashTable = new int[26];
		for(int i=0;i<hashTable.length;i++){
			hashTable[i]=0;
		}
		for(char c:magazine.toCharArray()){
			hashTable[c-'a']++;
		}
		for(char c:ransomNote.toCharArray()){
			hashTable[c-'a']--;
			if(hashTable[c-'a']<0)return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		System.out.println(obj.canConstruct("a", "b"));
		System.out.println(obj.canConstruct("aa", "ab"));
		System.out.println(obj.canConstruct("aa", "aab"));
		System.out.println(obj.canConstruct("fffbfg", "effjfggbffjdgbjjhhdegh"));
	}

}
