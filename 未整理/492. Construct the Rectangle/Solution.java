/**
 * Created by wf2015Lijia on 2017/2/27.
 */
public class Solution492 {
    public int[] constructRectangle(int area) {
        int[] result = new int[2];
        int maxx = (int) (Math.sqrt(area * 1.0));
        for (int i = maxx; i >= 1; i--) {
            if (area % i == 0) {
                result[0] = area / i;
                result[1] = i;
                break;
            }
        }
        return result;
    }
}
