import java.util.HashMap;
import java.util.Map;

public class Solution128 {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, true);
        }
        for (int num : nums) {
            if (map.get(num) == false) continue;
            map.put(num, false);
            int length = 1;
            int tmp = num;
            while (true) {
                tmp--;
                if (map.get(tmp) == null) break;
                map.put(tmp,false);
                length++;
            }
            tmp = num;
            while (true) {
                tmp++;
                if (map.get(tmp) == null) break;
                map.put(tmp,false);
                length++;
            }
            ans = Math.max(ans,length);
        }
        return ans;
    }

    public void test() {

    }
}
