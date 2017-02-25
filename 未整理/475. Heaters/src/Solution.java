import java.util.Arrays;

public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result = Integer.MIN_VALUE;
        
        for (int house : houses) {
        	int index = Arrays.binarySearch(heaters, house);
        	if (index < 0) {
        		index = -(index + 1);
        	}
        	int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
        	int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
        	
        	result = Math.max(result, Math.min(dist1, dist2));
        }
        
        return result;
    }
    
    public static void main(String[] args) {
		Solution obj = new Solution();
		int[] houses = new int[]{1,2,3};
		int[] heaters = new int[]{2,0};
		System.out.println(obj.findRadius(houses, heaters));
	}
}