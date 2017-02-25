public class Solution {
	public int findBinarySearch(int[] numbers,int l,int r,int tar){
		if(l>r||l<0||r<0||l>numbers.length||r>numbers.length)return -1;
		if(tar<numbers[l]||tar>numbers[r]){
			return -1;
		}
		if(l==r&&tar!=numbers[l]){
			return -1;
		}
		int mid = (l+r)/2;
		if(numbers[mid]==tar) return mid;
		if(numbers[mid]<tar) return findBinarySearch(numbers,mid+1,r,tar);
		if(numbers[mid]>tar) return findBinarySearch(numbers,l,mid-1,tar);
		return -1;
	}
	
    public int[] twoSum(int[] numbers, int target) {
    	int[] result = new int[2];
    	int len = numbers.length;
    	for(int i=0;i<len-1;i++){
    		int other = target-numbers[i];
    		int index2 = findBinarySearch(numbers,i+1,len-1,other);
    		if(index2!=-1){
    			result[0] = i+1;
    			result[1] = index2+1;
    			return result;
    		}
    	}
        return result;
    }
}