
public class Solution {
//	public Map<Integer,Integer> addNew(Map<Integer,Integer> existMap,int x,int n){
//		Map<Integer,Integer> newMap = new HashMap<Integer,Integer>(n);
//		Set<Integer> existSet = existMap.keySet();
//		for(int existNum:existSet){
//			int thisNumOfNum = existMap.get(existNum);
//			for(int i=1;i<=thisNumOfNum;i++){
//				int tmp = existNum*i+x;
//				if(tmp>n){
//					break;
//				}
//				int tmpNum = 1;
//				if(newMap.get(tmp)!=null){
//					tmpNum = newMap.get(tmp)+1;
//				}
//				newMap.put(tmp, tmpNum);
//			}
//		}
//		Set<Integer> addSet = newMap.keySet();
//		for(int existNum:addSet){
//			int tmpNum = 1;
//			if(existMap.get(existNum)!=null){
//				tmpNum = existMap.get(existNum) + 1;
//			}
//			existMap.put(existNum,tmpNum);
//		}
//		int tmpNum = 1;
//		if(existMap.get(x)!=null){
//			tmpNum = existMap.get(x) + 1;
//		}
//		existMap.put(x,tmpNum);
//		return existMap;
//	}
//	
//	public int check(Map<Integer,Integer> existMap,int n){
//		for(int i=1;i<=n;i++){
//			if(existMap.get(i)==null) return i;
//		}
//		return 0;
//	}
//	
//    public int minPatches(int[] nums, int n) {
//    	int ans = 0;
//    	Map<Integer,Integer> existMap = new HashMap<Integer,Integer>(n);
//    	for(int num:nums){
//    		existMap = addNew(existMap, num, n);
//    		if(check(existMap, n)==0) return 0;
//    	}
//    	while(true){
//    		int tmp = check(existMap, n);
//    		if(tmp==0) break;
//    		ans++;
//    		existMap = addNew(existMap, tmp, n);
//    	}
//        return ans;
//    }
	
	int minPatches(int[] nums, int n) {
        long miss = 1;
        int len = nums.length;
        int ret = 0, i = 0;
        while (miss <= n) {
            if (i < len && nums[i] <= miss) {
                miss += nums[i++];
            } else {
                miss <<= 1;
                ++ret;
            }
        }
        return ret;
    }
    
    public static void main(String[] args) {
		Solution obj = new Solution();
		int[] nums = new int[]{2,31,33};
		int n = 2147483647;
		System.out.println(obj.minPatches(nums, n));
	}
}